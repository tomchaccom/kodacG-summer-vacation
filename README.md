# kodacG-summer-vacation

### 1주차 - ERD, API 설계
| pr test

ERD 작성 초기 구상

먼저 엔티티 선정

- 사용자
- 상품
- 주문
- 쿠폰
- 장바구니

  관계 정의
  사용자 : 주문 = 1 : 0 ~ n
  주문 : 상품 = 1: 1 ~ n
  상품 : 쿠폰 = 1 : 1
  장바구니 : 주문 = 1 : 1 ~ n
  
