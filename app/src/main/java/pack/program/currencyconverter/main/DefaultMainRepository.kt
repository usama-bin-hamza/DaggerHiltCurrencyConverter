package pack.program.currencyconverter.main

import pack.program.currencyconverter.data.CurrencyApi
import pack.program.currencyconverter.data.models.CurrencyResponse
import pack.program.currencyconverter.utils.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository {
    override suspend fun getRates(): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates()
            val result = response.body()
            if (response.isSuccessful && result != null){
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An Error occured")
        }
    }
}