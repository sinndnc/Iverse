package com.iverse.core.data.repository.user

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.iverse.core.constant.FirestoreConstants
import com.iverse.core.domain.repository.user.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth
) : UserRepository {

    override fun getCurrentUser(): Task<QuerySnapshot> {
        val uid = firebaseAuth.currentUser!!.uid
        return firestore
            .collection(FirestoreConstants.USER_COLLECTION)
            .whereEqualTo(FirestoreConstants.USER_UID, uid)
            .get()
    }


    override fun getUserById(userUid: String): Task<DocumentSnapshot> {
        return firestore
            .collection(FirestoreConstants.USER_COLLECTION)
            .document(userUid)
            .get()
    }
}