<template>

    <div id="right" style="position: relative">
        <div id="chat_title" v-if="isToStaff">
            和{{toStaff}}的会话
        </div>
        <div id="chat_title" v-else>
            和{{toGroup}}的会话
        </div>
        <div id="show_msg" style="background-color: lightgoldenrodyellow;height:300px">
            <p v-for="m in msg" style="padding-bottom: 2px">{{m.name}}:{{m['msg']}}</p>
        </div>
        <div id="enter_msg" style="position:absolute;bottom: 0px">
            <textarea rows="3" cols="40" v-model="enter_msg">
            </textarea>
            <button @click="send()">发送</button>
        </div>
    </div>

</template>

<script>
    import bus from './eventBus'
    export default {
        name: 'right',
        data() {
            return {
                msg: [],
                enter_msg:null,
                stomp:null,
                toStaff:null,
                toGroup:null,
                isToStaff:true
            }
        },
        methods:{
            send:send
        },
        mounted: function () {
            bus.$on('openChat', res => {
                let allChatMsg = this.$store.state.allChatMsg;
                if(res['flag']==0){
                    this.isToStaff = true;
                    if(!allChatMsg['staff'][res['item']])
                        allChatMsg['staff'][res['item']]=[];
                    this.msg = allChatMsg['staff'][res['item']];
                    this.toStaff = res['item'];
                }else{
                    this.isToStaff = false;
                    if(!allChatMsg['group'][res['item']])
                        allChatMsg['group'][res['item']]=[];
                    this.msg = allChatMsg['group'][res['item']];
                    this.toGroup = res['item'];
                }
            });
        }
    }

    function send() {
        let stomp = this.$store.state.stomp;
        if(this.isToStaff){
            stomp.send("/sendMsgToStaff", {}, JSON.stringify({toStaff:this.toStaff,msg:this.enter_msg}));
            let allChatMsg = this.$store.state.allChatMsg;
            let data = {name:this.$store.state.userName,msg:this.enter_msg};
            if(!allChatMsg['staff'][this.toStaff])
                allChatMsg['staff'][this.toStaff]=[];
            allChatMsg['staff'][this.toStaff].push(data);
        }else{
            stomp.send("/sendMsgToGroup", {}, JSON.stringify({groupId:this.toGroup,msg:this.enter_msg}));
       /*     let allChatMsg = this.$store.state.allChatMsg;
            let data = {name:this.$store.state.userName,msg:this.enter_msg};
            if(!allChatMsg['group'][this.toGroup])
                allChatMsg['group'][this.toGroup]=[];
            allChatMsg['group'][this.toGroup].push(data);*/
        }
        console.log(JSON.stringify(this.$store.state.allChatMsg));
    }
</script>

<style>
    #right{
        background-color: bisque;
        height:500px;
    }

</style>
