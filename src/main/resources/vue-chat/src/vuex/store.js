import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        user: {}, //用户信息
        scene:{}
    },
    getters: {
        getUser: state => { //用户信息计算属性
            return state.user;
        }
    },
    mutations: {
        init (state, data) {
            state.user = data;
        },
        initScene (state, data) {
            state.scene = data;
        }
    }
})
export default store;