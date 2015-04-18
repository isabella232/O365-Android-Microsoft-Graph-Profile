package com.microsoft.office365.profile;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.microsoft.office365.profile.model.UserInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 4/9/2015.
 */
public class BasicInfoFragment extends Fragment implements
        JsonRequestListener, InputStreamRequestListener, View.OnClickListener {
    private static final String TAG = "BasicInfoFragment";
    protected static final String ACCEPT_HEADER = "application/json;odata.metadata=full;odata.streaming=true";

    protected TextView mDisplayNameTextView;
    protected TextView mJobTitleTextView;
    protected TextView mDepartmentTextView;
    protected TextView mHireDateTextView;
    protected TextView mMailTextView;
    protected TextView mTelephoneNumberTextView;
    protected TextView mStateTextView;
    protected TextView mCountryTextView;
    protected ImageView mThumbnailPhotoImageView;
    protected TextView mManagerDisplayName;
    protected TextView mManagerJobTitle;
    protected URL mUserEndpoint;
    protected URL mManagerEndpoint;
    protected URL mThumbnailPhotoEndpoint;
    protected UserInfo mManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_basic_info, container, false);

        mDisplayNameTextView = (TextView)fragmentView.findViewById(R.id.displayNameTextView);
        mJobTitleTextView = (TextView)fragmentView.findViewById(R.id.jobTitleTextView);
        mDepartmentTextView = (TextView)fragmentView.findViewById(R.id.departmentTextView);
        mHireDateTextView = (TextView)fragmentView.findViewById(R.id.hireDateTextView);
        mMailTextView = (TextView)fragmentView.findViewById(R.id.mailTextView);
        mTelephoneNumberTextView = (TextView)fragmentView.findViewById(R.id.telephoneNumberTextView);
        mStateTextView = (TextView)fragmentView.findViewById(R.id.stateTextView);
        mCountryTextView = (TextView)fragmentView.findViewById(R.id.countryTextView);
        mThumbnailPhotoImageView = (ImageView)fragmentView.findViewById(R.id.thumbnailPhotoImageView);
        mManagerDisplayName = (TextView)fragmentView.findViewById(R.id.managerDisplayName);
        mManagerJobTitle = (TextView)fragmentView.findViewById(R.id.managerJobTitle);

        mManagerDisplayName.setOnClickListener(this);
        mManagerJobTitle.setOnClickListener(this);

        try {
            ProfileApplication application = (ProfileApplication)getActivity().getApplication();
            mUserEndpoint = new URL(
                    Constants.GRAPH_RESOURCE_URL +
                    application.getTenant() +
                    "/users/" + ((ProfileActivity)getActivity()).getUserId());
            mThumbnailPhotoEndpoint = new URL(
                    Constants.GRAPH_RESOURCE_URL +
                    application.getTenant() +
                    "/users/" + ((ProfileActivity)getActivity()).getUserId() + "/thumbnailphoto");
            mManagerEndpoint = new URL(
                    Constants.GRAPH_RESOURCE_URL +
                    application.getTenant() +
                    "/users/" + ((ProfileActivity)getActivity()).getUserId() + "/manager");

            RequestManager
                    .getInstance()
                    .executeRequest(mUserEndpoint,
                            ACCEPT_HEADER,
                            this);
            RequestManager
                    .getInstance()
                    .executeRequest(mThumbnailPhotoEndpoint,
                            this);
            RequestManager
                    .getInstance()
                    .executeRequest(mManagerEndpoint,
                            ACCEPT_HEADER,
                            this);

        } catch (MalformedURLException e) {
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
            // TODO: handle the case where the URL is malformed
        }

        return fragmentView;
    }

    @Override
    public void onClick(View v){
        final Intent profileActivityIntent = new Intent(getActivity(), ProfileActivity.class);
        // Send the user's given name and displayable id to the SendMail activity
        profileActivityIntent.putExtra("userId", mManager.objectId);
        startActivity(profileActivityIntent);
    }

    @Override
    public void onRequestSuccess(final URL requestedEndpoint, final JsonElement data) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(requestedEndpoint.sameFile(mUserEndpoint)) {
                    UserInfo userInfo = new Gson().fromJson(data, UserInfo.class);
                    mDisplayNameTextView.setText(userInfo.displayName);
                    mJobTitleTextView.setText(userInfo.jobTitle);
                    mDepartmentTextView.setText(userInfo.department);
                    mHireDateTextView.setText(userInfo.hireDate);
                    mMailTextView.setText(userInfo.mail);
                    mTelephoneNumberTextView.setText(userInfo.telephoneNumber);
                    mStateTextView.setText(userInfo.state);
                    mCountryTextView.setText(userInfo.country);
                } else {
                    mManager = new Gson().fromJson(data, UserInfo.class);
                    mManagerDisplayName.setText(mManager.displayName);
                    mManagerJobTitle.setText(mManager.jobTitle);
                }
            }
        });
    }

    @Override
    public void onRequestSuccess(URL requestedEndpoint, InputStream data) {
        final Drawable thumbnailPhotoDrawable = Drawable.createFromStream(data, null);
        try {
            data.close();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mThumbnailPhotoImageView.setImageDrawable(thumbnailPhotoDrawable);
            }
        });
    }

    @Override
    public void onRequestFailure(URL requestedEndpoint, Exception e) {
        Log.e(TAG, e.getMessage());
        e.printStackTrace();
        //TODO: Implement error interface
    }
}
