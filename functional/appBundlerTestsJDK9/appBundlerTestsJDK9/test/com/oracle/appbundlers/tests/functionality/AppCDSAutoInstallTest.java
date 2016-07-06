/*
 * Copyright (c) 2015, 2016 Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package com.oracle.appbundlers.tests.functionality;

import static com.oracle.appbundlers.utils.BundlerUtils.DEB;
import static com.oracle.appbundlers.utils.BundlerUtils.DMG;
import static com.oracle.appbundlers.utils.BundlerUtils.EXE;
import static com.oracle.appbundlers.utils.BundlerUtils.MSI;
import static com.oracle.appbundlers.utils.BundlerUtils.PKG;
import static com.oracle.appbundlers.utils.BundlerUtils.RPM;
import static com.oracle.appbundlers.utils.Config.CONFIG_INSTANCE;
import static com.oracle.appbundlers.utils.installers.AbstractBundlerUtils.APPCDS_CACHE_FILE_EXISTS_INSTALL;
import static com.oracle.appbundlers.utils.installers.AbstractBundlerUtils.APPCDS_CACHE_FILE_EXISTS_RUN;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

import org.testng.annotations.AfterMethod;

import com.oracle.appbundlers.tests.functionality.functionalinterface.AdditionalParams;
import com.oracle.appbundlers.tests.functionality.functionalinterface.VerifiedOptions;
import com.oracle.appbundlers.tests.functionality.jdk9test.ExtensionType;
import com.oracle.appbundlers.utils.BundlerUtils;
import com.oracle.appbundlers.utils.Utils;

/**
 *
 * @author Dmitriy.Ermashov@oracle.com
 */
public class AppCDSAutoInstallTest extends TestBase {

    @Override
    protected BundlerUtils[] getBundlerUtils() {
        return new BundlerUtils[] { PKG, DMG, EXE, MSI, DEB, RPM };
    }

    public AdditionalParams getAdditionalParams() throws Exception {
        return () -> {
            Map<String, Object> additionalParams = new HashMap<>();
            additionalParams.put(UNLOCK_COMMERCIAL_FEATURES, true);
            additionalParams.put(ENABLE_APP_CDS, true);
            additionalParams.put(APP_CDS_CACHE_MODE, "auto+install");
            additionalParams.put(IDENTIFIER,
                    this.currentParameter.getApp().getIdentifier());
            return additionalParams;
        };
    }

    public VerifiedOptions getVerifiedOptions() {
        return () -> {
            Map<String, Object> verifiedOptions = new TreeMap<>();
            verifiedOptions.put(APPCDS_CACHE_FILE_EXISTS_INSTALL,
                    bundlingManager.getAppCDSCacheFile(
                            this.currentParameter.getApp(),
                            getResultingAppName()));
            verifiedOptions.put(APPCDS_CACHE_FILE_EXISTS_RUN,
                    bundlingManager.getAppCDSCacheFile(
                            this.currentParameter.getApp(),
                            getResultingAppName()));
            return verifiedOptions;
        };
    }

    @AfterMethod
    public void removeCacheFile() throws IOException, ExecutionException {
        Utils.runCommand(
                bundlingManager.getBundlerUtils()
                        .getRmCommand(bundlingManager.getAppCDSCacheFile(
                                this.currentParameter.getApp(),
                                getResultingAppName())),
                true, CONFIG_INSTANCE.getRunTimeout());
    }

    @Override
    public void overrideParameters(ExtensionType intermediate)
            throws Exception {
        this.currentParameter.setAdditionalParams(getAdditionalParams());
        this.currentParameter.setVerifiedOptions(getVerifiedOptions());
    }
}