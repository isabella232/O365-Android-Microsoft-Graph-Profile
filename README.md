# Office 365 Profile Sample for Android

![Office 365 Profile sample](/readme-images/O365-Android-Profile-Thumbnail.png)

The first page presents you with a list of users. The second page displays information about any user you choose to view. All of this information, including files shared with the user, the user's email address, hire date, manager, and direct reports, comes from unified endpoint.

## Device requirements

To run the Profile sample, your device needs to meet the following requirements:

* Android API level 14 or later.
 
## Prerequisites

To use the Office 365 Profile sample for Android you need the following:

* [Android Studio](http://developer.android.com/sdk/index.html) version 1.0 or later.
* An Office 365 account. You can sign up for [an Office 365 Developer subscription](http://aka.ms/o365-android-connect-signup) that includes the resources that you need to start building Office 365 apps.
* A client id and redirect uri values of an application registered in Azure. The application must run the **	NEED TO UPDATE** permission:

You can also [add a native client application in Azure](http://aka.ms/o365-android-connect-addapp) and [grant proper permissions](https://github.com/OfficeDev/O365-Android-Profile/wiki/Grant-permissions-to-the-Profile-application-in-Azure) to it.

## Open the sample using Android Studio

1. Install [Android Studio](http://developer.android.com/tools/studio/index.html#install-updates) and add the Android SDK packages according to the [instructions](http://developer.android.com/sdk/installing/adding-packages.html) on developer.android.com.
2. Download or clone this sample.
3. Start Android Studio.
	1. Select **Open an existing Android Studio project**.
	2. Browse to your local repository and select the O365-Android-Profile project. Click **OK**.
4. Open the Constants.java file.
	1. Find the CLIENT\_ID constant and set its String value equal to the client id you registered in Azure Active Directory.
	2. Find the REDIRECT\_URI constant and set its String value equal to the redirect URI you registered in Azure Active Directory.
    ![Office 365 Profile sample](/readme-images/O365-Android-Profile-Constants.png "Client ID and Redirect URI values in Constants file")

    > Note: If you have don't have CLIENT\_ID and REDIRECT\_URI values, [add a native client application in Azure](https://msdn.microsoft.com/library/azure/dn132599.aspx#BKMK_Adding) and take note of the CLIENT\_ID and REDIRECT_URI.

Once you've built the Profile sample, you can run it on an emulator or device.

## Questions and comments

We'd love to hear your feedback on this Profile sample for Android. Here's how you can send your questions and suggestions to us:

* In the [Issues](https://github.com/OfficeDev/O365-Android-Profile/issues) section of this repository.
* Send us an email to [docthis@microsoft.com](mailto:docthis@microsoft.com?subject=Feedback%20on%20the%20Office%20365%20Profile%20sample%20for%20Android).
  
## Additional resources

* [Office 365 APIs documentation](http://aka.ms/o365-android-connect-platformoverview)
* [Office 365 SDK for Android](http://aka.ms/o365-android-connect-sdk)
* [Office Dev Center for Android](http://aka.ms/o365-android-connect-getstarted)
* [Office 365 APIs code samples and videos](http://aka.ms/o365-android-connect-codesamples)
* [Other Office 365 unified endpoint samples](http://aka.ms/o365-unified-endpoint-codesamples) 

## Copyright
Copyright (c) 2015 Microsoft. All rights reserved.