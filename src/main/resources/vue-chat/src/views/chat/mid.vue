<template>

    <div id="mid">
        <div v-for="staff in staffList">
            <div @click="openChat(0,staff)"
                 style="width: 100%;height: 50px;margin: 5px auto;background-color: #5bc0de;cursor: pointer">{{staff}}
            </div>
        </div>
        <div @click="openChat(1,groupList[0]['groupId'])"
             style="width: 100%;height: 50px;margin: 5px auto;background-color: #5bc0de;cursor: pointer">{{groupList[0]['groupName']}}
        </div>
    </div>

</template>

<script>
    import bus from './eventBus'

    export default {
        name: 'mid',
        data() {
            return {
                groupList: [{"groupId":1,"groupName":"admin1+admin2+admin3"}]
            }
        },
        methods: {
            connect:connect,
            openChat: openChat
        },
        computed: { //通过计算属性 获取单例全局信息
            staffList: function () {
                return this.$store.state.staffList;
            }
        },
        mounted:function () {
            this.connect();
        }
    }

    function openChat(flag,item) {
        bus.$emit('openChat', {flag:flag,item:item});
    }

    /** function */
    function connect() {
        var sock = new SockJS("/endpointChat");
        this.stomp = Stomp.over(sock);
        this.stomp.connect({},  (frame) =>{
            console.log('Connected:' + frame);
            this.stomp.subscribe('/user/'+this.$store.state.userName+"/message",  (response) => {
                console.log('user response:' + response.body);
                let data = JSON.parse(response.body);
                let allChatMsg = this.$store.state.allChatMsg;
                if(!allChatMsg['staff'][data['name']])
                    allChatMsg['staff'][data['name']] = [];
                allChatMsg['staff'][data['name']].push(data);
            })
            this.stomp.subscribe('/group/1/message',  (response) => {
                console.log('group response:' + response.body);
                let data = JSON.parse(response.body);
                let allChatMsg = this.$store.state.allChatMsg;
                if(!allChatMsg['group']['1'])
                    allChatMsg['group']['1'] = [];
                allChatMsg['group']['1'].push(data);
            })
        });
        this.$store.commit('setStomp',this.stomp);
    }
</script>

<style>
    #mid {
        background-color: cadetblue;
        height: 500px;
    }
</style>
