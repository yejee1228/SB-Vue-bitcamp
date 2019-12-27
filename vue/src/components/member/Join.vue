<template>
<div id="wrap">
<form id="join_form">
    <div id="container" role="main">
        <div id="content">
            <div class="join_content">
                <div class="row_group">
                    <div class="join_row">
                        <h3 class="join_title"><label for="id">아이디</label></h3>
                        <span class="ps_box int_id">
							<input type="text" id="id" name="id" class="int" title="ID" maxlength="20"></span>
                        <span class="error_next_box" id="idMsg" style="display:none" aria-live="assertive"></span>
                    </div>
                    <div class="join_row">
                        <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
                        <span class="ps_box int_pass" id="pswd1Img">
							<input type="password" id="pswd1" name="pswd1" class="int" title="비밀번호 입력" aria-describedby="pswd1Msg" maxlength="20">
                            <span class="lbl"><span id="pswd1Span" class="step_txt"></span></span>
						</span>
                        <span class="error_next_box" id="pswd1Msg" style="display:none" aria-live="assertive">5~12자의 영문 소문자, 숫자와 특수기호(_)만 사용 가능합니다.</span>
                        <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
                        <span class="ps_box int_pass_check" id="pswd2Img">
							<input type="password" id="pswd2" name="pswd2" class="int" title="비밀번호 재확인 입력" aria-describedby="pswd2Blind" maxlength="20">
							<span id="pswd2Blind" class="wa_blind">설정하려는 비밀번호가 맞는지 확인하기 위해 다시 입력 해주세요.</span>
						</span>
                        <span class="error_next_box" id="pswd2Msg" style="display:none" aria-live="assertive"></span>
                    </div>
                </div>
                <div class="row_group">
                    <div class="join_row">
                        <h3 class="join_title"><label for="name">이름</label></h3>
                        <span class="ps_box box_right_space">
							<input type="text" id="name" name="name" title="이름" class="int" maxlength="40">
						</span>
                        <span class="error_next_box" id="nameMsg" style="display:none" aria-live="assertive"></span>
                    </div>
                    <div class="join_row join_birthday">
                        <h3 class="join_title"><label for="yy">생년월일</label></h3>
                        <div class="bir_wrap">
                            <div class="bir_yy">
								<span class="ps_box">
									<input type="text" id="yy" placeholder="년(4자)" aria-label="년(4자)" class="int" maxlength="4">
								</span>
                            </div>
                            <div class="bir_mm">
								<span class="ps_box">
									<select id="mm" class="sel" aria-label="월">
										<option value="">월</option>
										<option value="01">1</option>
										<option value="02">2</option>
										<option value="03">3</option>
										<option value="04">4</option>
										<option value="05">5</option>
										<option value="06">6</option>
										<option value="07">7</option>
										<option value="08">8</option>
										<option value="09">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
									</select>
								</span>
                            </div>
                            <div class=" bir_dd">
								<span class="ps_box">
									<input type="text" id="dd" placeholder="일" aria-label="일" class="int" maxlength="2">
									<label for="dd" class="lbl"></label>
								</span>
                            </div>
                        </div>
                        <span class="error_next_box" id="birthdayMsg" style="" aria-live="assertive">태어난 년도 4자리를 정확하게 입력하세요.</span>
                    </div>
                    <div class="join_row join_sex">
                        <h3 class="join_title"><label for="gender">성별</label></h3>
                        <div class="ps_box gender_code">
                            <select id="gender" name="gender" class="sel" aria-label="성별">
                                <option value="" selected="">성별</option>
                                        <option value="M">남자</option>
                                        <option value="F">여자</option>
                            </select>
                        </div>
                    </div>

                    
                    <div class="join_row join_skin">
                        <div>
                        <h3 class="join_title"><label for="skinType">피부타입</label></h3>
                        <div class="skinType_box">
                            <span class="type_box">
                                <select id="sel_skinType" class="sel" aria-label="선택">
                                    <option value="">선택</option>
                                    <option value="dry">건성</option>
                                    <option value="oil">지성</option>
                                    <option value="neutral">중성</option>
                                    <option value="mix">복합성</option>
                                </select>
                            </span>
                        </div>
                        </div>
                        <div>
                        <h3 class="join_title"><label for="skinProb">피부고민</label></h3>
                        <div class="skinProb_box">
                            <span class="type_box">
                                <select id="sel_skinProb" class="sel" aria-label="선택">
                                    <option value="">선택</option>
                                    <option value="sensitive">민감</option>
                                    <option value="atopy">아토피</option>
                                    <option value="acne">여드름</option>
                                    <option value="none">없음</option>
                                </select>
                            </span>
                        </div>
                        </div>
                        <div>
                        <h3 class="join_title"><label for="child">피부타입</label></h3>
                        <div class="child_box">
                            <span class="type_box">
                                <select id="sel_child" class="sel" aria-label="선택">
                                    <option value="">선택</option>
                                    <option value="true">유</option>
                                    <option value="false">무</option>
                                </select>
                            </span>
                        </div>
                        </div>
                            
                    </div>
                    <span class="error_next_box" id="genderMsg" style="display:none" aria-live="assertive"></span>
                    <span class="error_next_box" id="emailMsg" style="display:none" aria-live="assertive"></span>
                </div>
                <div class="btn_area">
                    <button type="button" id="btnJoin" class="btn_type btn_primary"><span>가입하기</span></button>
                </div>
            </div>
        </div>
    </div>
</form>
</div>
</template>
<script>
export default {
  data(){
    return{
    }
  }
}
</script>
<style scoped>
.bir_wrap, .join_skin {
    display: table;
    width: 100%;
}
.bir_dd, .bir_mm, .bir_yy {
    display: table-cell;
    table-layout: fixed;
    width: 147px;
    vertical-align: middle;
    display: block;
    float: left;
}
.bir_mm+.bir_dd, .bir_yy+.bir_mm {
    padding-left: 10px;
}
.ps_box, .ps_box_disable, .type_box {
    display: block;
    position: relative;
    width: 100%;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 14px 10px 14px;
    background: #fff;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    vertical-align: top;
}
body, button, input, select, table, textarea {
    font-family: Dotum,'돋움',Helvetica,sans-serif;
    font-size: 12px;
}
.join_birthday .ps_box {
    padding: 11px 14px;
}
.int {
    display: block;
    position: relative;
    width: 100%;
    height: 29px;
    line-height: 29px;
    border: none;
    background: #fff;
    font-size: 15px;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    z-index: 10;
    position: absolute;
    left: 0;
    apperance: none;
    -webkit-apperance: none;
}
:root .sel {
    background: #fff url(https://static.nid.naver.com/images/join/pc/sel_arr_2x.gif) 100% 50% no-repeat;
    -webkit-background-size: 20px 8px;
    background-size: 20px 8px;
}
.sel {
    width: 100%;
    height: 29px;
    padding: 7px 8px 6px 7px\9;
    font-size: 15px;
    line-height: 18px;
    color: #000;
    border: none;
    border-radius: 0;
    *height: auto;
    *margin-top: 3px;
    -webkit-appearance: none;
}
.join_title {
    margin: 19px 0 8px;
    font-size: 14px;
    font-weight: 700;
}
.btn_primary {
    color: #fff;
    background-color: #ff7f50d4;
}
.btn_type {
    display: block;
    width: 100%;
    padding: 21px 0 17px;
    font-size: 20px;
    font-weight: 700;
    text-align: center;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}
.btn_area {
    margin: 30px 0 9px;
}
</style>