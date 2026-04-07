# java-springboot-2026

- 스프링부트 학습 내용

## 3일차

### 웹 개요

- 구성 3단계
    - 웹브라우저(프론트엔드) - 사용자의 요청하고 결과를 돌려받는 화면. HTML/CSS/JS
    - 웹서버(백엔드) - 사용자 요청을 받아서 DB에 데이터 읽고, 프론트엔드에 보낼 데이터를 전송(응답)
    - 데이터베이스 - 데이터를 저장, 읽는 부분

- 웹 개념 : 사용자의 요청(`Request`)에 대한 서버의 응답(`Response`)

### Spring Boot

- Java를 기반으로 웹 서버를 만들 수 있는 백엔드 프레임워크 중 하나

- 이전 기술
    - CGI : 내용 생략
    - Servlet : CGI를 개선한 웹 기술. HTML을 Java소스 내 전부 작성(개발 난이도 상)
    - EJB(Enterprise Java Bean) : Servlet으로 대형 기업 프로젝트(개발 난이도 극상)
    - `JSP`(Java Server Page) : HTML과 Java소스를 분리. 쉽게 개발하도록 만든 기술(난이도 중)
        - 개발환경 구성 난이도가 높음
    - `Spring` : Java개발 전성기. 웹페이지와 Java영역 분리. 개발환경 구성 난이도 줄어듬
        - 개발환경 구성 난이도 중
        - 대한민국 전자정부 웹프레임워크 개발
    - `Spring Boot` : Spring 개발환경 구성 단점, 개발 단점 최소화

#### Spring Boot

- https://spring.io/