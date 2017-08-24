import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        userName: null, //用户信息
        staffList:[],
        allChatMsg:{"staff":{},"group":{}},
        stomp:null
    },
    mutations: {
        init (state, data) {
            state.userName = data['name'];
            state.staffList = data['staffList'];
        },
        setStomp(state, stomp){
            state.stomp = stomp;
        }
    }
})
export default store;