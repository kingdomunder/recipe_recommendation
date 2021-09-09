-- chef insert[사용자]
insert into chef values(0, 'admin', '0000', '0000');
insert into chef values(chef_id_seq.nextval, 'yoojinma', '1234', '1234');
insert into chef values(chef_id_seq.nextval, 'woosong', '5678', '5678');
insert into chef values(chef_id_seq.nextval, 'hyemin', '1111', '1111');

-- ingredient insert[재료]
insert into ingredient values(ingredient_id_seq.nextval, '밥', '김치', '돼지고기', '마늘', '파');
insert into ingredient values(ingredient_id_seq.nextval, '밥', '계란', '간장', '참기름', '깨');
insert into ingredient values(ingredient_id_seq.nextval, '파스타면', '토마토소스', '크림', '마늘', 'null');
-- 레시피 추가 
insert into ingredient values(ingredient_id_seq.nextval, '떡', '양파', '간장', '고추장', '파');
insert into ingredient values(ingredient_id_seq.nextval, '계란', '파', '양파', 'null', 'null');
insert into ingredient values(ingredient_id_seq.nextval, '밥', '소고기', '간장', '양파', '깨');
insert into ingredient values(ingredient_id_seq.nextval, '돼지고기', '김치', '간장', '고추장', '양파');
insert into ingredient values(ingredient_id_seq.nextval, '떡', '크림', '마늘', '깨', 'null');
insert into ingredient values(ingredient_id_seq.nextval, '파스타면', '참기름', '간장', '마늘', '깨');

-- recipe insert[레시피]
insert into recipe values(recipe_id_seq.nextval, 1, '김치찌개', ''||chr(10)||'1. 김치 반포기를 2cm 간격으로 썰어서 기름에 볶는다.(쓴 김치는 설탕을 추가한다.)'||chr(10)||'2. 고기나 참치를 넣고 계속 볶는다.'||chr(10)||'3. 어느 정도 익으면 물을 붓고 끓인다.'||chr(10)||'4. 나머지 부재료를 넣는다.', 3, '36');
insert into recipe values(recipe_id_seq.nextval, 2, '간장계란밥', ''||chr(10)||'1. 기름을 두른 팬에 계란을 2개 깬다.(노른자 터뜨리지 않게 주의!!)'||chr(10)||'2. 따뜻한 밥에 계란을 올린다.'||chr(10)||'3. 참기름과 간장과 깨를 뿌린다.', 2, '45');
-- recipe_owner 없는 기본 레시피 생성해보기
insert into recipe values(recipe_id_seq.nextval, 3, '로제파스타', ''||chr(10)||'1. 소금을 1t 넣은 물에 면을 삶는다.'||chr(10)||'2. 기름을 두른 팬에 마늘을 넣고 볶는다.'||chr(10)||'3. 마늘이 노릇해지면 토마토소스와 크림을 넣고 끓인다.'||chr(10)||'4. 면을 넣고 에멀징한다.', 0, '27');
-- 레시피 추가 
insert into recipe values(recipe_id_seq.nextval, 4, '떡볶이', ''||chr(10)||'1. 물을 끓인다.'||chr(10)||'2. 적당히 불린 떡을 넣는다.'||chr(10)||'3. 파송송 썰어서 재료들과 함께 넣는다.', 1, '45');
insert into recipe values(recipe_id_seq.nextval, 5, '계란말이', ''||chr(10)||'1. 식용유를 두른 팬을 달군다.'||chr(10)||'2. 계란을 잘 섞는다.'||chr(10)||'3. 계란말이 완성.', 0, '45');
insert into recipe values(recipe_id_seq.nextval, 6, '소불고기볶음밥', ''||chr(10)||'1. 소불고기소불고기'||chr(10)||'2. 조리법 정확히 기입해주세요.'||chr(10)||'3. 소불고기볶음밥 완성.', 2, '45');
insert into recipe values(recipe_id_seq.nextval, 7, '김치제육볶음', ''||chr(10)||'1. 김치를 준비한다.'||chr(10)||'2. 제육볶음을 만든다.'||chr(10)||'3. 제육볶음에 김치를 싸서 드셔보세요.', 3, '45');
insert into recipe values(recipe_id_seq.nextval, 8, '크림떡볶이', ''||chr(10)||'1. 크림을 준비한다.'||chr(10)||'2. 떡볶이를 만든다.'||chr(10)||'3. 궁중떡볶이 완성.', 3, '45');
insert into recipe values(recipe_id_seq.nextval, 9, '참깨오일파스타', ''||chr(10)||'1. 집에 올리브오일이 있을까요?'||chr(10)||'2. 올리브오일 대신 참기름을 사용해보세요 .'||chr(10)||'3. 따라하지 마세요.', 0, '99');

commit;

