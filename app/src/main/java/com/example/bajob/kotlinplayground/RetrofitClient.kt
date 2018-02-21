import com.example.bajob.kotlinplayground.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object RetrofitClient {

    private val okHttpClient = with(OkHttpClient
            .Builder()) {
        addInterceptor(HttpLoggingInterceptor()
                .apply { if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BODY else level = HttpLoggingInterceptor.Level.NONE })
        build()
    }
    private val retrofit = with(Retrofit
            .Builder()) {
        baseUrl("https://en.wikipedia.org/w/")
        addConverterFactory(MoshiConverterFactory.create())
        client(okHttpClient)
        build()
    }

    val apiEndpoints = retrofit.create(ApiEndpoints::class.java)

    interface ApiEndpoints {
        @GET("api.php")
        fun getSomethingFromServer(): Call<ResponseBody>
    }
}