package pack.program.currencyconverter.main

import pack.program.currencyconverter.data.models.CurrencyResponse
import pack.program.currencyconverter.utils.Resource

interface MainRepository {

    suspend fun getRates(): Resource<CurrencyResponse>

}