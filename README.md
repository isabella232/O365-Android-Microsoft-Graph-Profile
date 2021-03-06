# Office 365 Profile Sample for Android Using Microsoft Graph
[![Build Status](https://travis-ci.org/OfficeDev/O365-Android-Microsoft-Graph-Profile.svg?branch=master)](https://travis-ci.org/OfficeDev/O365-Android-Microsoft-Graph-Profile)

The first page presents you with a list of users. The second page displays information about any user you choose to view. All of this information, including files shared with the user, the user's alias, hire date, manager, direct reports, and groups comes from [Microsoft Graph](http://graph.microsoft.io/ "Overview of Microsoft Graph") (previously called Office 365 unified API).

The following image shows the user's page that displays the information mentioned above:

![Office 365 Profile sample](/readme-images/O365-Android-Profile-Thumbnail.png)

## Device requirements

To run the Profile sample, your device needs to meet the following requirements:

* Android API level 14 or later.
 
## Prerequisites

To use the Office 365 Profile sample for Android you need the following:

* [Android Studio](http://developer.android.com/sdk/index.html) version 1.0 or later.
* An Office 365 account. You can [join the Office 365 Developer Program and get a free 1 year subscription to Office 365](https://aka.ms/devprogramsignup) that includes the resources that you need to start building Office 365 apps.
      > Note: If you already have a subscription, the previous link sends you to a page that says *Sorry, you can’t add that to your current account*. In that case use an account from your current Office 365 subscription.
* A client ID and redirect URI values of an application registered in Microsoft Azure. The application must run the   following permissions:
    * **Microsoft Graph**
        * Read items in all site collections
        * Read all files that user can access
        * Access directory as the signed in user
        * Read all users' basic profiles

You can also [add a native client application in Azure](https://msdn.microsoft.com/office/office365/HowTo/add-common-consent-manually#bk_RegisterNativeApp) and [grant proper permissions](https://github.com/OfficeDev/O365-Android-Profile/wiki/Grant-permissions-to-the-Profile-application-in-Azure) to it.

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

    > Note: If you don't have CLIENT\_ID and REDIRECT\_URI values, [add a native client application in Azure](https://msdn.microsoft.com/office/office365/HowTo/add-common-consent-manually#bk_RegisterNativeApp) and take note of the CLIENT\_ID and REDIRECT_URI.

Once you've built the Profile sample, you can run it on an emulator or device.

## Questions and comments

We'd love to get your feedback on the O365 Android Profile project. You can send your questions and suggestions to us in the [Issues](https://github.com/OfficeDev/O365-Android-Profile/issues) section of this repository.

Questions about Office 365 development in general should be posted to [Stack Overflow](http://stackoverflow.com/questions/tagged/Office365+API). Make sure that your questions or comments are tagged with [Office365] and [API].
  
## Additional resources

* [Office 365 APIs platform overview](https://msdn.microsoft.com/office/office365/howto/platform-development-overview)
* [Overview of Microsoft Graph](http://graph.microsoft.io/)
* [Office 365 SDK for Android](https://github.com/OfficeDev/Office-365-SDK-for-Android)
* [Get started with Office 365 APIs in apps](https://msdn.microsoft.com/office/office365/howto/getting-started-Office-365-APIs)
* [Office 365 API code samples and videos](https://msdn.microsoft.com/office/office365/howto/starter-projects-and-code-samples)
* [Other Office 365 Profile samples](https://github.com/OfficeDev?utf8=%E2%9C%93&query=Profile)
* [Office 365 Connect Sample for Android](https://github.com/OfficeDev/O365-Android-Connect)
* [Office 365 Code Snippets for Android](https://github.com/OfficeDev/O365-Android-Snippets)
* [Office 365 APIs Starter Project for Android](https://github.com/OfficeDev/O365-Android-Start)

## Copyright
Copyright (c) 2015 Microsoft. All rights reserved.


This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information, see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.
