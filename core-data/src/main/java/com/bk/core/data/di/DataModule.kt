package com.net.parissportifdemo.di

import com.bk.core.data.repository.TeamsRepository
import com.bk.core.data.repository.TeamsRepositoryImp
import com.net.core.network.ParisSportifNetwork
import com.net.core.network.retrofit.ParisSportifRetrofitNetwork
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsSportNetwork(niANetwork: ParisSportifRetrofitNetwork): ParisSportifNetwork

    companion object {
        @Provides
        @Singleton
        fun providesNetworkJson(): Json = Json {
            ignoreUnknownKeys = true
        }
    }
    @Binds
    fun bindsTeamsRepository(teamsRepositoryImp: TeamsRepositoryImp): TeamsRepository
}
