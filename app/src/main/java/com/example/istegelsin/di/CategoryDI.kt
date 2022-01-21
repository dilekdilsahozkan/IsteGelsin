package com.example.istegelsin.di

import com.example.istegelsin.data.remote.AllAPI
import com.example.istegelsin.data.repository.CategoryRepository
import com.example.istegelsin.data.repository.CategoryRepositoryImpl
import com.example.istegelsin.domain.AllUseCase
import com.example.istegelsin.presentation.CategoryViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CategoryDI{
    companion object {
        val module = module {

            viewModel { CategoryViewModel(get()) }

            single <AllAPI> {

                val interceptor = HttpLoggingInterceptor()
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://apitest.pazarama.com")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


                retrofit.create(AllAPI::class.java)
            }

            single<CategoryRepository> { CategoryRepositoryImpl(get()) }

            single { AllUseCase(get()) }
        }
    }
}