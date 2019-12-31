import Vue from 'vue'
import Vuex from 'vuex'
import mutations from '@/store/mutations'
import getters from '@/store/getters'
import person from '@/store/modules/person'
import article from '@/store/modules/article'
import states from '@/store/states'
Vue.use(Vuex)

export const store = new Vuex.Store({
  modules : {
		states,
		mutations,
		getters,
		person,
		article
	},
	strict: true
})