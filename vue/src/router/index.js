import Vue from "vue"
import Router from "vue-router"
import List from "@/components/board/List.vue"
import Remove from "@/components/board/Remove.vue"
import Search from "@/components/board/Search.vue"
import Update from "@/components/board/Update.vue"
import Write from "@/components/board/Write.vue"
import Login from "@/components/member/Login.vue"
import Join from "@/components/member/Join.vue"
import MyPage from "@/components/member/MyPage.vue"

Vue.use(Router)
export default new Router({
	mode : 'history',
	routes : [
		{path: '/list', name : 'list', component: List},
		{path: '/remove', name : 'remove', component: Remove},
		{path: '/search', name : 'search', component: Search},
		{path: '/update', name : 'update', component: Update},
		{path: '/write', name : 'write', component: Write},
		{path: '/login', name : 'login', component: Login},
		{path: '/join', name : 'join', component: Join},
		{path: '/mypage', name : 'mypage', component: MyPage}
	]
})
