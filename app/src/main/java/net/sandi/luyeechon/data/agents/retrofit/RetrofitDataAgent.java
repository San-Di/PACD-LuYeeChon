package net.sandi.luyeechon.data.agents.retrofit;

import net.sandi.luyeechon.data.agents.LuYeeChonDataAgent;
import net.sandi.luyeechon.data.models.MotivatorModel;
import net.sandi.luyeechon.data.responses.MotivatorListResponse;
import net.sandi.luyeechon.utils.CommonInstances;
import net.sandi.luyeechon.utils.LuYeeChonConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kaung Htet Lin on 9/27/2016.
 */
public class RetrofitDataAgent implements LuYeeChonDataAgent{


    private static RetrofitDataAgent objInstance;

    private final LuYeeChonApi theApi;

    private RetrofitDataAgent() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(LuYeeChonConstants.LUYEECHON_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance())) //response
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(LuYeeChonApi.class);  //interface not need to implement . framework will done
    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadMotivator() {
        Call<MotivatorListResponse> loadMotivatorCall = theApi.loadMotivator(LuYeeChonConstants.ACCESS_TOKEN);
        loadMotivatorCall.enqueue(new Callback<MotivatorListResponse>() {  //preparatin state  before request
            @Override
            public void onResponse(Call<MotivatorListResponse> call, Response<MotivatorListResponse> response) {
                MotivatorListResponse motivatorListResponse = response.body();
                if (motivatorListResponse == null) {
                    MotivatorModel.getInstance().notifyErrorInLoadingMotivator(response.message());
                } else {
                   MotivatorModel.getInstance().notifyMotivatorLoaded(motivatorListResponse.getMotivatorList());
                }
            }

            @Override
            public void onFailure(Call<MotivatorListResponse> call, Throwable throwable) {
                MotivatorModel.getInstance().notifyErrorInLoadingMotivator(throwable.getMessage());
            }
        });
    }
}
