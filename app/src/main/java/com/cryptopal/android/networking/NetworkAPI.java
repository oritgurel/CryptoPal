package com.cryptopal.android.networking;

/**
 * Created by danielszasz on 15/03/2018.
 */

public class NetworkAPI {
    private static final NetworkAPI ourInstance = new NetworkAPI();

    public static NetworkAPI getInstance() {
        return ourInstance;
    }

    private NetworkAPI() {
    }


}
