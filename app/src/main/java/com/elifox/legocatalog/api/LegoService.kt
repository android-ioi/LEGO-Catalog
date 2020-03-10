package com.elifox.legocatalog.api

import com.elifox.legocatalog.di.LegoAPI
import com.elifox.legocatalog.legoset.data.LegoSet
import com.elifox.legocatalog.legotheme.data.LegoTheme
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Lego REST API access points
 */
interface LegoService {

    companion object {
        const val ENDPOINT = "https://rebrickable.com/api/v3/"
    }

    @LegoAPI
    @GET("lego/themes/")
    suspend fun getThemes(@Query("page") page: Int? = null,
                  @Query("page_size") pageSize: Int? = null,
                  @Query("ordering") order: String? = null): Response<ResultsResponse<LegoTheme>>

    @LegoAPI
    @GET("lego/sets/")
    suspend fun getSets(@Query("page") page: Int? = null,
                        @Query("page_size") pageSize: Int? = null,
                        @Query("theme_id") themeId: Int? = null,
                        @Query("ordering") order: String? = null): Response<ResultsResponse<LegoSet>>

    @LegoAPI
    @GET("lego/sets/{id}/")
    suspend fun getSet(@Path("id") id: String): Response<LegoSet>

}
