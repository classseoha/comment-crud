# Comment CRUD

## 📌 프로젝트 목적

이 프로젝트는 일정을 등록하고, 댓글 및 대댓글 기능을 통해 사용자 간의 소통이 가능한 간단한
커뮤니케이션 플랫폼을 구현하는 것을 목표로 합니다. RESTful한 API 설계와 JPA의 활용, Spring의 기본 원리를
기반으로 한 구조적인 개발을 통해 백엔드 기초 역량을 탄탄히 다지는 데 목적이 있습니다.


## 📌 주요 기능

### LV0. 기초 설계
* ERD 작성
* REST API 명세서 작성
### LV1. 일정 CRUD
* 일정 생성, 조회(전체/단일), 수정, 삭제 기능
* nickname, title, content, createdAt, updatedAt 필드 포함
* JPA Auditing을 통한 생성일/수정일 자동 관리
### LV2. 댓글 CRUD
* 일정에 댓글 추가 가능
* 댓글의 생성, 조회, 수정, 삭제 기능
* scheduleId를 통한 일정과의 연관 관계 설정
* JPA Auditing 적용
### LV3. 일정과 댓글 연계 조회
* 일정 목록 조회 시, 각 일정의 댓글 수 표시
* 일정 상세 조회 시, 해당 일정에 달린 댓글 목록을 오름차순 정렬로 함께 반환
### LV4. 대댓글
* 댓글에 대한 답글 기능 (1 Depth 까지만 허용)
* commentId를 통한 부모-자식 댓글 관계 설정
* 부모 댓글 -> 대댓글 순으로 정렬하여 조회


## 📌 개발 환경 및 기술 스택

* Backend : Java, Spring Boot, Spring Data JPA
* Dependencies : Lombok, JPA Auditing, Spring Web
* DB : MySQL
* ORM : JPA + Hibernate
* Documentation : Markdown
* Build Tool : Gradle


## 📌 API 명세서 및 동작 캡처본

https://www.notion.so/teamsparta/API-1e62dc3ef5148075863bf1cedc401bdd?pvs=4

* 일정 생성

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EC%9D%BC%EC%A0%95%EC%83%9D%EC%84%B1.png?raw=true">

* 일정 전체 조회

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EC%9D%BC%EC%A0%95%EC%A0%84%EC%B2%B4%EC%A1%B0%ED%9A%8C.png?raw=true">

* 일정 특정 조회

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EC%9D%BC%EC%A0%95%ED%8A%B9%EC%A0%95%EC%A1%B0%ED%9A%8C.png?raw=true">

* 일정 수정

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EC%9D%BC%EC%A0%95%EC%88%98%EC%A0%95.png?raw=true">

* 일정 삭제

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EC%9D%BC%EC%A0%95%EC%82%AD%EC%A0%9C.png?raw=true">

* 댓글 생성

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EB%8C%93%EA%B8%80%EC%83%9D%EC%84%B1.png?raw=true">

* 댓글 조회

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EB%8C%93%EA%B8%80%EC%A1%B0%ED%9A%8C.png?raw=true">

* 댓글 수정

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EB%8C%93%EA%B8%80%EC%88%98%EC%A0%95.png?raw=true">

* 댓글 삭제

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EB%8C%93%EA%B8%80%EC%82%AD%EC%A0%9C.png?raw=true">

* 대댓글 생성

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EB%8C%80%EB%8C%93%EA%B8%80%EC%83%9D%EC%84%B1.png?raw=true">

* 대댓글 조회

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EB%8C%80%EB%8C%93%EA%B8%80%EC%A1%B0%ED%9A%8C.png?raw=true">

* 대댓글 수정

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EB%8C%80%EB%8C%93%EA%B8%80%EC%88%98%EC%A0%95.png?raw=true">

* 대댓글 삭제

<img src="https://github.com/classseoha/comment-crud/blob/main/APIcapture/%EB%8C%80%EB%8C%93%EA%B8%80%EC%82%AD%EC%A0%9C.png?raw=true">


## 📌 ERD

<img src="https://github.com/classseoha/comment-crud/blob/main/ERD.png?raw=true">


## 📌 Git Commit Message Convention

* Feat : 새로운 기능 추가
* Fix : 버그 수정
* Style : 코드 포맷팅, 코드 오타, 함수명 수정 등 스타일 수정
* Refactor : 코드 리팩토링(동일 기능 내 코드 개선)
* Comment : 주석 수정 및 삭제
* Docs : 문서와 관련된 모든 것
* Chore : 빌드 설정 변경 및 기타 환경설정
