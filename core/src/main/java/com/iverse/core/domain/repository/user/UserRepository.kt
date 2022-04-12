package com.iverse.core.domain.repository.user

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

interface UserRepository {

    fun getCurrentUser(): Task<QuerySnapshot>

    fun getUserById(userUid: String): Task<DocumentSnapshot>

    fun updateCurrentUserToken(token: String): Task<Void>
}