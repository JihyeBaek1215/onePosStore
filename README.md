


1. 매장등록

* 매장등록 (회원가입)
http://localhost:8085/stores

{
 "storeName" : "맛집1호점"
,"repName" : "김탁구"
,"repPhonNum" :"01047567552"
,"passWd" : "12345"
,"tableCnt" :"10"
}

{
 "storeName" : "맛집2호점"
,"repName" : "오탁구"
,"repPhonNum" :"01047567552"
,"passWd" : "12345"
,"tableCnt" :"10"
}


* 매장조회 (=>> 개발 테스트시 23으로 고정)
http://localhost:8085/stores/23


##########################################################################


2. 메뉴등록

* 메뉴등록
http://localhost:8085/menus

{
"storeId" : "23"
,"menuNm" : "라면"
,"amt" : "5000"
,"qty" : "10"
}

{
"storeId" : "23"
,"menuNm" : "김밥"
,"amt" : "3000"
,"qty" : "10"
}

{
"storeId" : "24"
,"menuNm" : "김밥"
,"amt" : "4000"
,"qty" : "10"
}


* 메뉴조회 (=>> 개발 테스트시 23으로 고정)
http://localhost:8085/menus   (매장ID로 조회 하는 방법 구현 필요!! , http://localhost:8085/menus?storeID=23)


##########################################################################

3. 매출등록

* 서빙pub -> 정산sub 이나, 정산MSA 기능 부재로 일단 매장MSA 포함
* Test를 위해 주방(kitchen) 완료시 저장되도록 함 => PolicyHandler.java
 - kafka 내부오류 발생하여 try~catch 일단 주석처리
 - MSA 간 전달 파리미터/유형 협의 필요. Test 를 위해 아무 값이나 매핑처리


