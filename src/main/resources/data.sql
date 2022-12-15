INSERT INTO CORPORATION(CORPORATION_ID, CORPORATION_NAME)
VALUES
(1, '법인1'),
(2, '법인2'),
(3, '법인3');

INSERT INTO DEPARTMENT(DEPARTMENT_ID, DEPARTMENT_NAME, UPPER_DEPARTMENT_ID, CORPORATION_ID, CREATED_BY)
VALUES
(1, '최상위부서1(법1)', NULL, 1, 'NONE'),
(2, '최상위부서2(법1)', NULL, 1, 'NONE'),
(3, '최상위부서3(법1)', NULL, 1, 'NONE'),
(4, '최상위부서1(법2)', NULL, 2, 'NONE'),
(5, '최상위부서2(법2)', NULL, 2, 'NONE'),
(6, '최상위부서3(법2)', NULL, 2, 'NONE'),
(7, '최상위부서1(법3)', NULL, 3, 'NONE'),
(8, '최상위부서2(법3)', NULL, 3, 'NONE'),
(9, '최상위부서3(법3)', NULL, 3, 'NONE'),
(11, '상위부서1(얍1)', 1, 1, 'NONE'),
(12, '상위부서2(얍1)', 1, 1, 'NONE'),
(13, '상위부서3(얍1)', 1, 1, 'NONE'),
(14, '상위부서1(얍2)', 2, 1, 'NONE'),
(15, '상위부서2(얍2)', 2, 1, 'NONE'),
(16, '상위부서3(얍2)', 2, 1, 'NONE'),
(17, '상위부서1(얍3)', 3, 1, 'NONE'),
(18, '상위부서2(얍3)', 3, 1, 'NONE'),
(19, '상위부서3(얍3)', 3, 1, 'NONE'),
(21, '중위부서1(얍1)', 11, 1, 'NONE'),
(22, '중위부서2(얍1)', 11, 1, 'NONE'),
(23, '중위부서3(얍1)', 12, 1, 'NONE'),
(24, '중위부서1(얍2)', 12, 1, 'NONE'),
(25, '중위부서2(얍2)', 13, 1, 'NONE'),
(26, '중위부서3(얍2)', 13, 1, 'NONE'),
(27, '중위부서1(얍3)', 14, 1, 'NONE'),
(28, '중위부서2(얍3)', 14, 1, 'NONE'),
(29, '중위부서3(얍3)', 15, 1, 'NONE')
;


INSERT INTO DEPARTMENT_EMPLOYEE(DEPARTMENT_ID, EMPLOYEE_ID, POSITION_CODE, CREATED_BY)
VALUES
(1, 'jd', 'LEADER', 'NONE'),
(1, 'jdd', 'MEMBER', 'NONE'),
(1, 'jdm', 'MEMBER', 'NONE'),
(1, 'retire1', 'MEMBER', 'NONE'),
(1, 'retire2', 'MEMBER', 'NONE'),
(14, 'jd', 'LEADER', 'NONE'),
(16, 'jdd', 'MEMBER', 'NONE'),
(17, 'jdm', 'MEMBER', 'NONE'),
(21, 'jd', 'LEADER', 'NONE'),
(21, 'jdd', 'MEMBER', 'NONE'),
(22, 'jdd', 'MEMBER', 'NONE'),
(23, 'jdm', 'MEMBER', 'NONE')
;


INSERT INTO DEPARTMENT_HISTORY(DEPARTMENT_ID, HISTORY_DATE, DEPARTMENT_NAME, UPPER_DEPARTMENT_ID, CORPORATION_ID)
VALUES
(1,  '2022-11-23', '최상위부서1(법1)', NULL, 1),
(2,  '2022-11-23', '최상위부서2(법1)', NULL, 1),
(3,  '2022-11-23', '최상위부서3(법1)', NULL, 1),
(4,  '2022-11-23', '최상위부서1(법2)', NULL, 2),
(5,  '2022-11-23', '최상위부서2(법2)', NULL, 2),
(6,  '2022-11-23', '최상위부서3(법2)', NULL, 2),
(7,  '2022-11-23', '최상위부서1(법3)', NULL, 3),
(8,  '2022-11-23', '최상위부서2(법3)', NULL, 3),
(9,  '2022-11-23', '최상위부서3(법3)', NULL, 3),
(11, '2022-11-23',  '상위부서1(얍1)', 1, 1),
(12, '2022-11-23',  '상위부서2(얍1)', 1, 1),
(13, '2022-11-23',  '상위부서3(얍1)', 1, 1),
(14, '2022-11-23',  '상위부서1(얍2)', 2, 1),
(15, '2022-11-23',  '상위부서2(얍2)', 2, 1),
(16, '2022-11-23',  '상위부서3(얍2)', 2, 1),
(17, '2022-11-23',  '상위부서1(얍3)', 3, 1),
(18, '2022-11-23',  '상위부서2(얍3)', 3, 1),
(19, '2022-11-23',  '상위부서3(얍3)', 3, 1),
(21, '2022-11-23',  '중위부서1(얍1)', 11, 1),
(22, '2022-11-23',  '중위부서2(얍1)', 11, 1),
(23, '2022-11-23',  '중위부서3(얍1)', 12, 1),
(24, '2022-11-23',  '중위부서1(얍2)', 12, 1),
(25, '2022-11-23',  '중위부서2(얍2)', 13, 1),
(26, '2022-11-23',  '중위부서3(얍2)', 13, 1),
(27, '2022-11-23',  '중위부서1(얍3)', 14, 1),
(28, '2022-11-23',  '중위부서2(얍3)', 14, 1),
(29, '2022-11-23',  '중위부서3(얍3)', 15, 1)
;


INSERT INTO DEPARTMENT_EMPLOYEE_HISTORY(DEPARTMENT_ID, EMPLOYEE_ID, HISTORY_DATE, POSITION_CODE)
VALUES
(1, 'jd',   '2022-11-23', 'LEADER'),
(1, 'jdd',  '2022-11-23', 'MEMBER'),
(1, 'retire1',  '2022-11-23', 'MEMBER'),
(1, 'retire2',  '2022-11-23', 'MEMBER'),
(14, 'jd',  '2022-11-23', 'LEADER'),
(16, 'jdd', '2022-11-23',  'MEMBER'),
(17, 'jdm', '2022-11-23',  'MEMBER'),
(21, 'jd',  '2022-11-23', 'LEADER'),
(21, 'jdd', '2022-11-23',  'MEMBER'),
(22, 'jdd', '2022-11-23',  'MEMBER'),
(23, 'jdm', '2022-11-23',  'MEMBER')
;

INSERT INTO EMPLOYEE (EMPLOYEE_ID, PASSWORD, NAME, BIRTH_DAY, EMPLOYEE_NUMBER, CREATED_BY, RETIRE_DATE)
VALUES
('jd', '$2a$10$jVJyaeF.IA4uJ7dzET0llunYkT7GuOFxMMxC2a.LGNn9Y2CoZYDEq', 'ㅇㅇ', '2000-10-10', 'KD234', 'NONE', NULL),
('jdd', '$2a$10$oEFaYdKdy1uLtWe4msadfO/m79YZVRBcmCFkGGUkin05nQiJsuQIi', 'ㄹㅇ 아버지', '2001-10-10', 'AS435', 'NONE', NULL),
('jdm', '$2a$10$TJocLCiPKcG4p2fF3/BBtOEksPHT7ieUjhLGIzbFEpOtZUqGPGCOK', 'ㄴㅇ 어머니', '2002-10-10', 'FD544', 'NONE', NULL),
('retire1', '$2a$10$TJocLCiPKcG4p2fF3/BBtOEksPHT7ieUjhLGIzbFEpOtZUqGPGCOK', '퇴사직원1', '2000-10-10', 'FD544', 'NONE', '2022-11-24'),
('retire2', '$2a$10$TJocLCiPKcG4p2fF3/BBtOEksPHT7ieUjhLGIzbFEpOtZUqGPGCOK', '퇴사직원2', '2000-10-10', 'FD544', 'NONE', '2022-11-25');