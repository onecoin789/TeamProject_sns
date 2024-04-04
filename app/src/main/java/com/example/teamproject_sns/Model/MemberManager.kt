package com.example.teamproject_sns.Model



object MemberManager {
    private val memberList = mutableListOf<Info>()


    fun addMember(info:Info){
        memberList.add(info)
    }

    fun findMember(email:String):Info?{
        return memberList.find { it.email == email }
    }
    fun removeMember(email:String){
        val memberToRemove = memberList.find{it.email == email}
        memberToRemove?.let {
            memberList.remove(it)
        }
    }
}