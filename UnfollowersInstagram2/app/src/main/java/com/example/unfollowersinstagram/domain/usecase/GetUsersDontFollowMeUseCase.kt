package com.example.unfollowersinstagram.domain.usecase

import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Axel Sanchez
 */
interface GetUsersDontFollowMeUseCase{
    suspend fun call(query: String): DataProducts
}

@Singleton
class GetUsersDontFollowMeUseCaseImpl @Inject constructor(private val repository: ProductRepository):
    GetUsersDontFollowMeUseCase {
    override suspend fun call(query: String): DataProducts {
        return repository.getProductsBySearch(query)
    }
}