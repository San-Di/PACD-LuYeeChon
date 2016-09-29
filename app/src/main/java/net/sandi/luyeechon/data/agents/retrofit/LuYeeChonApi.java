package net.sandi.luyeechon.data.agents.retrofit;

import net.sandi.luyeechon.data.responses.MotivatorListResponse;
import net.sandi.luyeechon.data.responses.QuizListResponse;
import net.sandi.luyeechon.utils.LuYeeChonConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Kaung Htet Lin on 9/27/2016.
 */
public interface LuYeeChonApi {
    @FormUrlEncoded
    @POST(LuYeeChonConstants.API_GET_MOTIVATOR_LIST)
        //@POST type of call method
        // parameter name of api
    Call<MotivatorListResponse> loadMotivator(  //if parsed json will return AttratinListResponse coz of api
                                                @Field(LuYeeChonConstants.PARAM_ACCESS_TOKEN) String param);  //request parameter

    @FormUrlEncoded
    @POST(LuYeeChonConstants.API_GET_QUIZ_LIST)
    Call<QuizListResponse> loadQuiz(
            @Field(LuYeeChonConstants.PARAM_ACCESS_TOKEN) String param);


    //if u need another request @Field(MyanmarAttractionsConstants.PARAM_ACCESS_TOKEN) String param); like this and change some function
    //retrofit dataagent in some function
}
