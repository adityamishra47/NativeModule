package com.nativemodules;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class MyNativeModule extends ReactContextBaseJavaModule {
    static ReactContext reactApplicationContext;

    public MyNativeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactApplicationContext = reactApplicationContext;
    }

    @NonNull
    @Override
    public String getName() {
        return "LoginModule";
    }

    @ReactMethod
    public void openLoginPage() {
        Intent loginIntent = new Intent(reactApplicationContext, LoginActivty.class);
        getCurrentActivity().startActivity(loginIntent);
    }

    @ReactMethod
    public void openSignupPage() {
        Intent loginIntent = new Intent(reactApplicationContext, SignupActivity.class);
        getCurrentActivity().startActivity(loginIntent);
    }

    static void btnLoginClickEvent(String username, String password) {
        WritableMap params = Arguments.createMap();
        params.putString("username", username);
        params.putString("password", password);
        sendLoginEvent(reactApplicationContext, "loginClick", params);
    }

    private static void sendLoginEvent(ReactContext reactContext,
                                       String eventName,
                                       @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }

    static void btnSignupClickEvent(String username, String email, String password) {
        WritableMap map = Arguments.createMap();
        map.putString("username", username);
        map.putString("email", email);
        map.putString("password", password);
        sendSignupEvent(reactApplicationContext, map);
    }

    private static void sendSignupEvent(ReactContext reactContext,
                                        WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("signupClick", params);
    }

}
