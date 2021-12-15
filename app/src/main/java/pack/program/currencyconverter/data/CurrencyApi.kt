package pack.program.currencyconverter.data

import pack.program.currencyconverter.data.models.CurrencyResponse
import pack.program.currencyconverter.utils.Constants.Companion.ACCESS_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET(value = "v1/latest")
    suspend fun getRates(
        @Query("access_key")
        apiKey : String = ACCESS_KEY,
        @Query("format")
        format: Int = 1,
    ): Response<CurrencyResponse>
}