package com.varenia.kenante_chat.core

import com.varenia.kenante_chat.interfaces.KenanteChatFileUploadListener
import java.io.File

object KenanteTasks {

    val TAG = KenanteTasks::class.java
    var fileUploadListener: KenanteChatFileUploadListener? = null

    fun uploadFile(file: File, listener: KenanteChatFileUploadListener){
        this.fileUploadListener = listener

        val fileId = 1
        val fileName = file.toString().substring(file.toString().lastIndexOf("/") + 1)
        val extension = fileName.substring(fileName.lastIndexOf(".") + 1)
        val fileUrl = "https://www.testurl.com"

        fileUploadListener?.onSuccess(KenanteFile(fileId, fileName, fileUrl,
                extension))

    }

}