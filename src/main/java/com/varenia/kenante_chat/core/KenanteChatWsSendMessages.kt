package com.varenia.kenante_chat.core

import com.varenia.kenante_chat.enums.KenanteChatMessageAction
import com.varenia.kenante_chat.enums.KenanteMsgParams
import org.json.JSONObject

internal object KenanteChatWsSendMessages{

    val TAG = KenanteChatWsSendMessages::class.java.simpleName

    fun sendMessage(chatMessage: KenanteChatMessage){

        val json = JSONObject()

        json.put(KenanteMsgParams.room_id.name ,chatMessage.roomId)
        json.put(KenanteMsgParams.sender_id.name, chatMessage.senderId)
        json.put(KenanteMsgParams.receiver_id.name, chatMessage.receiverId)
        json.put(KenanteMsgParams.message.name, chatMessage.message)
        json.put(KenanteMsgParams.action.name, chatMessage.action)
        json.put(KenanteMsgParams.media_url.name, chatMessage.mediaUrl)
        json.put(KenanteMsgParams.channel.name, chatMessage.channel)

        KenanteChatWebSocket.sendMessage(json.toString())

    }

    fun leaveChat(userId: Int){

        val json = JSONObject()
        json.put(KenanteMsgParams.sender_id.name, userId)
        json.put(KenanteMsgParams.action.name, KenanteChatMessageAction.Leave.name)

        KenanteChatWebSocket.sendMessage(json.toString())

    }

}