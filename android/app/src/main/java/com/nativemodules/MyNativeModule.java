package com.nativemodules;

import android.content.Intent;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class MyNativeModule extends ReactContextBaseJavaModule {

    public MyNativeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "LoginModule";
    }

    @ReactMethod
    public void openLoginPage() {
        Intent loginIntent = new Intent(getCurrentActivity(), LoginActivty.class);
        getCurrentActivity().startActivity(loginIntent);
    }

    @ReactMethod
    public void openSignupPage() {
        Intent loginIntent = new Intent(getCurrentActivity(), SignupActivity.class);
        getCurrentActivity().startActivity(loginIntent);
    }

}
