package com.example.foodtower

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject


class FoodRec : JobService() {
    val AppID = "04feeb48145bdcd5832c07e9a2d778ac"
    val Kota = "Medan"
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.w("TAG","Mulai")
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.w("TAG","Berhenti")
        getFoodRec(params)
        return true
    }
    private fun getFoodRec(params: JobParameters?) {
        var client = AsyncHttpClient()
        var url = "https://nutritionix-api.p.rapidapi.com/v1_1/search/KFC?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat"
        val charSet = Charsets.UTF_8
        var handler = object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                var result = responseBody?.toString(charSet) ?: "Kosong"
                Log.w("TAG", result)
                jobFinished(params, false)
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                jobFinished(params, true)
            }
        }
        client.get(url,handler)

    }

}