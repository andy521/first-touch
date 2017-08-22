import Vue from 'vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
import store from './vuex/store'
//自定义组件
import App from './App.vue'
import CHAT from './views/chat/chat.vue'

(() => {
    Vue.use(VueResource);
    Vue.use(VueRouter);

    const routes = [
        { path: '/', component: CHAT },
        { path: '/chat', component: CHAT }
    ]

    const router = new VueRouter({
        routes
    })

    new Vue({
        el: '#app',
        router: router,
        store,
        render: h => h(App)
    })
})()