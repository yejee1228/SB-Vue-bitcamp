import Vue from 'vue'
import Vuex from 'vuex'
import common from '@/store/modules/common'
import student from '@/store/modules/student'
import admin from '@/store/modules/admin'
import article from '@/store/modules/article'
Vue.use(Vuex)

export const store = new Vuex.Store({
  modules : {
		student,
		admin,
		article,
		common
	},
	strict: true
})