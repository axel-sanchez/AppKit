package com.example.unfollowersinstagram.data.service

import com.example.unfollowersinstagram.data.models.InstagramResponseDTO
import com.example.unfollowersinstagram.helpers.Constants.GET_FOLLOWING
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Axel Sanchez
 */
interface ApiServiceFollower {
    @GET(GET_FOLLOWING)
    suspend fun getFollowing(@Query("userid") userName: String): Response<InstagramResponseDTO?>
}