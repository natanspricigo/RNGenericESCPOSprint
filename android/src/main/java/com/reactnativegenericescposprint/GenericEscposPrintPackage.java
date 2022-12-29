package com.reactnativegenericescposprint;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.reactnativegenericescposprint.escpos.RNBluetoothEscposPrinterModule;
import com.reactnativegenericescposprint.tsc.RNBluetoothTscPrinterModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericEscposPrintPackage implements ReactPackage {
    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        BluetoothService bluetoothService = new BluetoothService(reactContext);
        modules.add(new GenericEscposPrintModule(reactContext, bluetoothService));
        modules.add(new RNBluetoothTscPrinterModule(reactContext, bluetoothService));
        modules.add(new RNBluetoothEscposPrinterModule(reactContext, bluetoothService));
        return modules;
    }

    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

}
