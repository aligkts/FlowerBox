package com.aligkts.flowerbox.internal.util

import com.aligkts.flowerbox.internal.util.functional.Either

abstract class UseCase<out Type, in Params> where Type : Any {

    protected abstract suspend fun buildUseCase(params: Params): Type

    suspend fun run(params: Params): Either<Failure, Type> {
        return try {
            Either.Right(buildUseCase(params))
        } catch (failure: Failure) {
            Either.Left(failure)
        }
    }

    object None {
        override fun toString() = "UseCase.None"
    }
}
