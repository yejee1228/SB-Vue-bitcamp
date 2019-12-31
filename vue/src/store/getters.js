import { mapGetters } from 'vuex'

export default {
  // ...
  computed: {
    // getter를 객체 전개 연산자(Object Spread Operator)로 계산하여 추가합니다.
    ...mapGetters([
      'doneTodosCount',
      'anotherGetter',
      // ...
    ])
  },
  getError_state : state => state.error_state,
  getContext : state => state.context,
  getLoginstate : state => state.loginstate,
  getSidebar : state => state.sidebar,
  getHeaderMessage : state => state.headerMessage,
  getList : state => state.list,
}