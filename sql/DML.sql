-- chef insert[사용자]
insert into chef values(chef_id_seq.nextval, 'chef1', '1234');
insert into chef values(chef_id_seq.nextval, 'chef2', '5678');
insert into chef values(chef_id_seq.nextval, 'chef3', '0000');

-- ingredient insert[재료]
insert into ingredient values(ingredient_id_seq.nextval, '밥', '김치', '돼지고기', '마늘', '파');
insert into ingredient values(ingredient_id_seq.nextval, '밥', '계란', '간장', '참기름', '깨');
insert into ingredient values(ingredient_id_seq.nextval, '파스타면', '토마토소스', '크림', '마늘', 'null');

-- recipe insert[레시피]
insert into recipe values(recipe_id_seq.nextval, 1, '김치찌개', '1. 김치 반포기를 2cm 간격으로 썰어서 기름에 볶는다.(쓴 김치는 설탕을 추가한다.)'||chr(10)||'2. 고기나 참치를 넣고 계속 볶는다.'||chr(10)||'3. 어느 정도 익으면 물을 붓고 끓인다.'||chr(10)||'4. 나머지 부재료를 넣는다.', 3, '36');
insert into recipe values(recipe_id_seq.nextval, 2, '간장계란밥', '1. 기름을 두른 팬에 계란을 2개 깬다.(노른자 터뜨리지 않게 주의!!)'||chr(10)||'2. 따뜻한 밥에 계란을 올린다.'||chr(10)||'3. 참기름과 간장과 깨를 뿌린다.'||chr(10)||'', 2, '45');
-- recipe_owner 없는 기본 레시피 생성해보기
insert into recipe (recipe_id, ingredient_id, food_name, direction, recipe_like) values(recipe_id_seq.nextval, 3, '로제파스타', '1. 소금을 1t 넣은 물에 면을 삶는다.'||chr(10)||'2. 기름을 두른 팬에 마늘을 넣고 볶는다.'||chr(10)||'3. 마늘이 노릇해지면 토마토소스와 크림을 넣고 끓인다.'||chr(10)||'4. 면을 넣고 에멀징한다.','27');

commit;

