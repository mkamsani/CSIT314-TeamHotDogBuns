INSERT INTO user_account
(is_active, user_profile, password_hash, username, email, first_name, last_name, address, date_of_birth, time_created, time_last_login)
VALUES
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_00', 'user_00', 'user00@example.com', 'Leif',      'Stokes',       '06983 Mercedez Club, Alaineland, CA 61198',                    '1950-02-22', '2022-07-21 08:30:23.116467 +00:00', '2022-10-11 08:30:23.116467 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_01', 'user_01', 'user01@example.com', 'Marilu',    'Rohan',        '69886 Bennie Vista, Port Terinaland, PA 04757',                '1934-01-10', '2023-03-26 08:30:23.123665 +00:00', '2023-04-11 08:30:23.123665 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_02', 'user_02', 'user02@example.com', 'Kathrin',   'Senger',       '6076 Wisoky Highway, Cronamouth, AK 77123',                    '1985-02-17', '2022-09-26 08:30:23.124770 +00:00', '2023-02-13 08:30:23.124770 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_03', 'user_03', 'user03@example.com', 'Heriberto', 'Swift',        '492 Katharine Islands, South Brent, NC 75754',                 '1974-03-19', '2023-03-21 08:30:23.125715 +00:00', '2023-05-06 08:30:23.125715 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_04', 'user_04', 'user04@example.com', 'Lianne',    'Schinner',     '2606 Stroman Throughway, Port Busterborough, ND 21726',        '1970-08-10', '2023-02-01 08:30:23.126834 +00:00', '2023-03-19 08:30:23.126834 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_05', 'user_05', 'user05@example.com', 'Sam',       'Gerhold',      'Suite 582 18537 Stefanie Passage, Lake Ardathshire, NY 45325', '1953-01-17', '2023-04-27 08:30:23.127760 +00:00', '2023-04-29 08:30:23.127760 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_06', 'user_06', 'user06@example.com', 'Dane',      'Kulas',        'Apt. 361 6223 Britt Square, North Angelineville, CT 71888',    '1963-07-07', '2022-08-15 08:30:23.128541 +00:00', '2022-08-29 08:30:23.128541 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_07', 'user_07', 'user07@example.com', 'Billye',    'Nicolas',      '508 Lance Village, Tamikofort, VT 11596',                      '1938-01-04', '2022-05-23 08:30:23.129314 +00:00', '2022-11-04 08:30:23.129314 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_08', 'user_08', 'user08@example.com', 'Della',     'Macejkovic',   '0740 Schulist Village, East Davisberg, CT 34280',              '1990-09-28', '2022-09-29 08:30:23.130081 +00:00', '2023-04-21 08:30:23.130081 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_09', 'user_09', 'user09@example.com', 'Son',       'Terry',        '733 Darrell Ville, North Tamica, MN 17874',                    '1982-03-12', '2022-09-27 08:30:23.131562 +00:00', '2023-01-24 08:30:23.131562 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_10', 'user_10', 'user10@example.com', 'Jerald',    'Ryan',         'Suite 767 907 Harold Port, Williamfurt, OH 33883',             '1968-04-22', '2022-09-21 08:30:23.132331 +00:00', '2022-11-23 08:30:23.132331 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_11', 'user_11', 'user11@example.com', 'Lenard',    'Weissnat',     '443 Mike Fields, West Laurence, VT 32195',                     '1962-09-04', '2023-02-18 08:30:23.132956 +00:00', '2023-04-23 08:30:23.132956 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_12', 'user_12', 'user12@example.com', 'Pete',      'Jerde',        'Apt. 860 00551 Leannon Manor, Lake Genevieve, TN 60254',       '1976-03-05', '2022-09-02 08:30:23.133564 +00:00', '2022-12-10 08:30:23.133564 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_13', 'user_13', 'user13@example.com', 'Ara',       'Gaylord',      'Suite 280 91120 Walter Loaf, Wilburnhaven, CO 56489',          '1982-12-13', '2022-11-15 08:30:23.134258 +00:00', '2023-01-21 08:30:23.134258 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_14', 'user_14', 'user14@example.com', 'Willena',   'Koch',         '192 Cassy Drive, North Madeleine, VA 62609',                   '1929-03-28', '2022-09-02 08:30:23.134845 +00:00', '2022-09-19 08:30:23.134845 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_15', 'user_15', 'user15@example.com', 'Leandro',   'Schoen',       'Suite 512 9284 Torp Village, Franeckiland, DE 05639',          '1993-02-15', '2022-12-13 08:30:23.135595 +00:00', '2023-01-18 08:30:23.135595 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_16', 'user_16', 'user16@example.com', 'Huey',      'Gaylord',      '54963 Gleason Springs, Fernandoland, UT 49315',                '1930-10-07', '2022-11-26 08:30:23.136362 +00:00', '2022-12-28 08:30:23.136362 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_17', 'user_17', 'user17@example.com', 'Olen',      'Little',       'Suite 839 2117 Klein Viaduct, East Morganville, MO 59944',     '1971-04-11', '2022-06-13 08:30:23.137030 +00:00', '2022-10-21 08:30:23.137030 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_18', 'user_18', 'user18@example.com', 'Stuart',    'Trantow',      '183 Heidenreich Squares, Isiahshire, WA 91249',                '1998-01-21', '2022-08-07 08:30:23.137827 +00:00', '2022-12-11 08:30:23.137827 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_19', 'user_19', 'user19@example.com', 'Vanna',     'Roberts',      '333 Allyn Fields, Okunevahaven, NJ 54708',                     '1963-08-01', '2023-02-28 08:30:23.138538 +00:00', '2023-03-31 08:30:23.138538 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_20', 'user_20', 'user20@example.com', 'Kenneth',   'Hane',         '87734 Renner Shores, New Bong, CT 69671',                      '1988-05-06', '2023-02-12 08:30:23.139216 +00:00', '2023-04-20 08:30:23.139216 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_21', 'user_21', 'user21@example.com', 'Leora',     'Cartwright',   'Apt. 449 966 Bruen Oval, North Elvishaven, ND 06332',          '1998-12-16', '2022-06-04 08:30:23.139764 +00:00', '2022-11-19 08:30:23.139764 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_22', 'user_22', 'user22@example.com', 'Abby',      'Reichert',     '618 Donte Flats, Port Ramonita, NY 53174',                     '1948-07-31', '2022-08-27 08:30:23.140318 +00:00', '2023-03-15 08:30:23.140318 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_23', 'user_23', 'user23@example.com', 'Claudio',   'Hansen',       '106 Littel Drive, Maggiofort, KS 27293',                       '1935-10-03', '2023-02-10 08:30:23.140851 +00:00', '2023-04-20 08:30:23.140851 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_24', 'user_24', 'user24@example.com', 'Shayne',    'Reinger',      '9527 Tomas Streets, Hartmannmouth, HI 26255',                  '1999-12-15', '2022-05-09 08:30:23.141378 +00:00', '2022-05-23 08:30:23.141378 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_25', 'user_25', 'user25@example.com', 'Omar',      'Simonis',      'Suite 794 755 Bins Rapid, Stoltenbergmouth, MT 11978',         '1943-02-09', '2022-12-23 08:30:23.141928 +00:00', '2023-03-05 08:30:23.141928 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_26', 'user_26', 'user26@example.com', 'Meagan',    'Hilpert',      '55702 Cormier Junctions, Port Annatown, NV 69514',             '2003-07-24', '2023-04-27 08:30:23.142468 +00:00', '2023-05-06 08:30:23.142468 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_27', 'user_27', 'user27@example.com', 'Chance',    'Lind',         '395 Etsuko Harbors, Lake Ida, PA 34603',                       '1954-08-20', '2022-11-15 08:30:23.142984 +00:00', '2023-04-17 08:30:23.142984 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_28', 'user_28', 'user28@example.com', 'Kenny',     'Dibbert',      '46683 Wilkinson Trail, Ankundingmouth, WA 31252',              '1931-07-31', '2022-07-06 08:30:23.143512 +00:00', '2023-04-06 08:30:23.143512 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_29', 'user_29', 'user29@example.com', 'Vida',      'Kulas',        '703 Dibbert Plains, East Pamouth, MI 38068',                   '1954-03-29', '2023-01-17 08:30:23.144074 +00:00', '2023-03-03 08:30:23.144074 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_30', 'user_30', 'user30@example.com', 'Roderick',  'Heaney',       'Suite 827 8031 Denesik Islands, New Estebanland, MD 37308',    '1960-08-12', '2022-10-04 08:30:23.144613 +00:00', '2022-11-25 08:30:23.144613 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_31', 'user_31', 'user31@example.com', 'Latonya',   'Von',          'Suite 430 975 Taisha River, East Harriett, UT 76745',          '1987-01-12', '2022-06-27 08:30:23.145187 +00:00', '2022-09-25 08:30:23.145187 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_32', 'user_32', 'user32@example.com', 'Dino',      'White',        '363 Stiedemann Pines, Tromphaven, DE 52104',                   '1963-03-17', '2023-04-16 08:30:23.145706 +00:00', '2023-04-27 08:30:23.145706 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_33', 'user_33', 'user33@example.com', 'Theola',    'Gutmann',      'Apt. 786 54984 Boyce Run, Schambergertown, SC 20005',          '2004-11-19', '2022-06-08 08:30:23.146250 +00:00', '2022-06-11 08:30:23.146250 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_34', 'user_34', 'user34@example.com', 'Lisha',     'MacGyver',     'Suite 973 22042 Jessie Meadow, Port Geralyn, OK 60871',        '1968-02-12', '2022-07-20 08:30:23.146834 +00:00', '2023-02-11 08:30:23.146834 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_35', 'user_35', 'user35@example.com', 'Ami',       'Senger',       '8051 Halvorson Course, Grahamton, GA 86712',                   '1982-01-20', '2023-03-15 08:30:23.147400 +00:00', '2023-03-23 08:30:23.147400 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_36', 'user_36', 'user36@example.com', 'Scot',      'Gulgowski',    '161 Louann Park, Fadelmouth, TN 61498',                        '1999-09-04', '2022-10-03 08:30:23.147887 +00:00', '2023-03-19 08:30:23.147887 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_37', 'user_37', 'user37@example.com', 'Elwood',    'Brekke',       '0023 Floyd Station, Luisview, MI 18791',                       '1980-06-29', '2022-11-07 08:30:23.148373 +00:00', '2023-02-22 08:30:23.148373 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_38', 'user_38', 'user38@example.com', 'Terence',   'Schaefer',     '63358 Will Harbor, Veumtown, FL 67442',                        '1940-01-10', '2022-11-18 08:30:23.148911 +00:00', '2023-01-31 08:30:23.148911 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_39', 'user_39', 'user39@example.com', 'Genevieve', 'Jones',        '7805 Strosin Extensions, New Isidromouth, WY 92504',           '1978-02-11', '2022-08-03 08:30:23.149421 +00:00', '2023-04-15 08:30:23.149421 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_40', 'user_40', 'user40@example.com', 'Ward',      'Cummerata',    'Suite 195 83824 Bartoletti View, Olsonberg, GA 31789',         '1999-06-06', '2022-10-11 08:30:23.149927 +00:00', '2023-04-21 08:30:23.149927 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_41', 'user_41', 'user41@example.com', 'Bennett',   'Rempel',       '25241 Marisha Prairie, North Brittmouth, VA 35550',            '1939-11-25', '2022-06-26 08:30:23.150667 +00:00', '2022-07-09 08:30:23.150667 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_42', 'user_42', 'user42@example.com', 'Darius',    'Kuhlman',      'Apt. 540 7615 Kuhic Throughway, O''Haraberg, AR 42532',        '1986-03-09', '2023-04-23 08:30:23.151286 +00:00', '2023-04-26 08:30:23.151286 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_43', 'user_43', 'user43@example.com', 'Merrill',   'Heller',       '68212 Carter Gardens, Chassidyport, IN 73822',                 '2003-11-08', '2022-07-09 08:30:23.151840 +00:00', '2022-10-25 08:30:23.151840 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_44', 'user_44', 'user44@example.com', 'Augustine', 'Lockman',      'Apt. 757 702 Mayer Road, West Eileenberg, IL 42616',           '1963-03-12', '2022-10-07 08:30:23.152462 +00:00', '2022-10-12 08:30:23.152462 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_45', 'user_45', 'user45@example.com', 'Donny',     'Hauck',        'Apt. 212 277 Peggie Cove, West Kizziechester, MS 50305',       '1933-09-12', '2022-07-01 08:30:23.153025 +00:00', '2022-10-18 08:30:23.153025 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_46', 'user_46', 'user46@example.com', 'Rosaria',   'Feil',         '376 Monahan Groves, Brownside, TN 40713',                      '1967-10-18', '2022-07-13 08:30:23.153549 +00:00', '2022-10-15 08:30:23.153549 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_47', 'user_47', 'user47@example.com', 'Tad',       'McLaughlin',   '06708 Velvet Fall, Rueckertown, SC 91353',                     '1934-11-05', '2022-11-02 08:30:23.154029 +00:00', '2022-11-08 08:30:23.154029 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_48', 'user_48', 'user48@example.com', 'Taren',     'McKenzie',     '2478 Ben Summit, Port Erickfort, RI 12253',                    '1967-12-25', '2023-03-12 08:30:23.154486 +00:00', '2023-04-14 08:30:23.154486 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_49', 'user_49', 'user49@example.com', 'Andreas',   'Witting',      'Suite 293 620 Lowe Plaza, South Desmondbury, CA 68464',        '1949-09-03', '2022-10-26 08:30:23.154976 +00:00', '2022-12-09 08:30:23.154976 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_50', 'user_50', 'user50@example.com', 'Shannon',   'Schaefer',     '3832 Weber Unions, North Larondaborough, VA 52320',            '1976-01-01', '2023-01-19 08:30:23.155469 +00:00', '2023-03-28 08:30:23.155469 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_51', 'user_51', 'user51@example.com', 'Lanell',    'Reichel',      '53678 Constance River, North Paris, PA 67409',                 '1934-07-12', '2023-03-05 08:30:23.155943 +00:00', '2023-04-02 08:30:23.155943 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_52', 'user_52', 'user52@example.com', 'Jennifer',  'Lowe',         '034 Israel Junctions, Alicestad, AZ 87322',                    '1991-10-07', '2023-01-21 08:30:23.156420 +00:00', '2023-03-07 08:30:23.156420 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_53', 'user_53', 'user53@example.com', 'Clifton',   'McClure',      'Apt. 858 452 O''Kon Fall, South Michel, OH 82469',             '1973-08-17', '2022-09-14 08:30:23.156919 +00:00', '2023-04-20 08:30:23.156919 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_54', 'user_54', 'user54@example.com', 'Tarsha',    'Sauer',        '4818 Tyisha Manors, South Doretta, ID 43342',                  '1989-12-11', '2022-05-12 08:30:23.157387 +00:00', '2023-02-03 08:30:23.157387 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_55', 'user_55', 'user55@example.com', 'Rachele',   'Bode',         '63741 Wiza Skyway, Antoneborough, AL 89019',                   '1972-07-21', '2022-10-26 08:30:23.157846 +00:00', '2023-02-13 08:30:23.157846 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_90', 'user_90', 'user90@example.com', 'Latrina',   'Kris',         'Apt. 022 9806 Lynn Coves, Weberland, TN 31613',                '1927-06-11', '2022-06-17 08:30:23.173147 +00:00', '2022-10-07 08:30:23.173147 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_56', 'user_56', 'user56@example.com', 'Jarrod',    'O''Hara',      'Apt. 971 080 Haley Fort, Lake Jefferson, AK 39089',            '1972-07-12', '2023-04-23 08:30:23.158295 +00:00', '2023-04-29 08:30:23.158295 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_57', 'user_57', 'user57@example.com', 'Floria',    'Torphy',       'Apt. 088 28463 Lorenzo Groves, New Roselynmouth, GA 99314',    '1997-07-07', '2022-09-01 08:30:23.158900 +00:00', '2022-11-18 08:30:23.158900 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_58', 'user_58', 'user58@example.com', 'Phyliss',   'Hermiston',    '00850 Gislason Greens, South Angelika, CT 56118',              '1926-12-27', '2023-02-11 08:30:23.159341 +00:00', '2023-04-11 08:30:23.159341 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_59', 'user_59', 'user59@example.com', 'Shaina',    'Tillman',      'Apt. 761 3366 Wiegand Mission, Ankundingville, CA 92022',      '1955-08-20', '2023-03-16 08:30:23.159794 +00:00', '2023-04-12 08:30:23.159794 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_60', 'user_60', 'user60@example.com', 'Cody',      'Hauck',        '65066 Pacocha Vista, Champlinville, MA 51258',                 '1999-07-15', '2023-01-18 08:30:23.160239 +00:00', '2023-04-05 08:30:23.160239 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_61', 'user_61', 'user61@example.com', 'Lyman',     'Bailey',       '90556 Pat Vista, New Elayne, VT 46201',                        '1982-04-19', '2022-08-28 08:30:23.160663 +00:00', '2022-09-29 08:30:23.160663 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_62', 'user_62', 'user62@example.com', 'Retta',     'Pfannerstill', '802 Wisoky Greens, Sheryllmouth, DE 81810',                    '1976-09-27', '2022-07-16 08:30:23.161085 +00:00', '2022-12-04 08:30:23.161085 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_63', 'user_63', 'user63@example.com', 'Aurora',    'Fay',          '5544 Witting Expressway, Port Jovitashire, WV 46610',          '1959-10-09', '2023-01-30 08:30:23.161591 +00:00', '2023-03-10 08:30:23.161591 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_64', 'user_64', 'user64@example.com', 'Greg',      'Schimmel',     '133 Ernest Crossroad, Lynchton, NJ 28732',                     '1964-04-24', '2022-10-01 08:30:23.162234 +00:00', '2023-02-13 08:30:23.162234 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_65', 'user_65', 'user65@example.com', 'Karen',     'Stoltenberg',  '6934 Welch Glens, Mullerton, NM 74386',                        '1966-01-09', '2022-11-28 08:30:23.162655 +00:00', '2023-04-05 08:30:23.162655 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_66', 'user_66', 'user66@example.com', 'Dewitt',    'Christiansen', '6395 Heather Ports, Roseannview, WY 77420',                    '1970-11-23', '2022-08-29 08:30:23.163089 +00:00', '2022-11-14 08:30:23.163089 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_67', 'user_67', 'user67@example.com', 'Micaela',   'Green',        'Apt. 104 18904 Kshlerin Locks, Port Marceloshire, NY 42759',   '1979-04-07', '2022-09-22 08:30:23.163545 +00:00', '2022-12-27 08:30:23.163545 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_68', 'user_68', 'user68@example.com', 'Dean',      'Ortiz',        'Apt. 499 40033 Gerlach Terrace, Lake Gerald, PA 23312',        '1966-09-17', '2022-07-09 08:30:23.163987 +00:00', '2023-01-20 08:30:23.163987 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_69', 'user_69', 'user69@example.com', 'Gail',      'Dooley',       'Suite 444 20796 Valeria Crescent, Windlerport, IN 87576',      '1973-02-22', '2023-01-13 08:30:23.164408 +00:00', '2023-01-21 08:30:23.164408 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_70', 'user_70', 'user70@example.com', 'Gertude',   'Auer',         'Apt. 450 494 Pfeffer Tunnel, Harveyport, OR 87665',            '1928-09-26', '2022-10-04 08:30:23.164834 +00:00', '2022-10-11 08:30:23.164834 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_71', 'user_71', 'user71@example.com', 'Josue',     'Huels',        'Apt. 342 08235 Kilback Keys, West Taylorberg, SC 12623',       '1950-09-08', '2022-10-01 08:30:23.165272 +00:00', '2023-01-18 08:30:23.165272 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_72', 'user_72', 'user72@example.com', 'John',      'Kunze',        'Suite 571 649 Funk Courts, Brianburgh, CO 25921',              '1952-10-20', '2022-10-07 08:30:23.165676 +00:00', '2023-04-01 08:30:23.165676 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_73', 'user_73', 'user73@example.com', 'Eugena',    'Kunde',        '90787 Rau Shore, South Aleishaborough, WI 86975',              '1991-04-13', '2023-01-14 08:30:23.166111 +00:00', '2023-03-08 08:30:23.166111 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_74', 'user_74', 'user74@example.com', 'Doug',      'Fadel',        '14375 Floretta Parkway, Vonniemouth, TN 67579',                '1925-12-04', '2022-05-27 08:30:23.166519 +00:00', '2022-10-07 08:30:23.166519 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_75', 'user_75', 'user75@example.com', 'Perry',     'Schamberger',  '10681 Osvaldo Prairie, Kyongfurt, ND 47868',                   '1984-01-26', '2023-03-15 08:30:23.166933 +00:00', '2023-05-06 08:30:23.166933 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_76', 'user_76', 'user76@example.com', 'Willy',     'Murphy',       'Apt. 919 43753 Tiffany Square, Hoegertown, PA 89156',          '1931-05-09', '2023-03-24 08:30:23.167368 +00:00', '2023-04-10 08:30:23.167368 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_77', 'user_77', 'user77@example.com', 'Suellen',   'Lubowitz',     '9047 Pearlene Drive, South Creolaville, NJ 92907',             '1981-08-25', '2022-08-29 08:30:23.167788 +00:00', '2022-10-07 08:30:23.167788 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_78', 'user_78', 'user78@example.com', 'Mittie',    'Stiedemann',   '9671 Towne Roads, Nicolettemouth, IA 57635',                   '1962-03-02', '2022-09-29 08:30:23.168231 +00:00', '2023-01-20 08:30:23.168231 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_79', 'user_79', 'user79@example.com', 'Willow',    'Wunsch',       '453 Rippin Underpass, Tracymouth, TX 22374',                   '1995-11-17', '2023-04-18 08:30:23.168698 +00:00', '2023-04-18 08:30:23.168698 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_80', 'user_80', 'user80@example.com', 'Eve',       'Russel',       'Suite 272 42582 Alverta Shore, Port Abigail, AR 75146',        '1938-01-15', '2023-04-27 08:30:23.169124 +00:00', '2023-05-04 08:30:23.169124 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_81', 'user_81', 'user81@example.com', 'Teddy',     'Halvorson',    'Suite 951 4551 Weldon Court, Lake Claudiaborough, WA 85951',   '1940-11-02', '2022-12-22 08:30:23.169554 +00:00', '2023-04-25 08:30:23.169554 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_82', 'user_82', 'user82@example.com', 'Viola',     'McLaughlin',   '890 Paucek Drive, Port Erickmouth, AZ 43276',                  '1984-07-10', '2022-11-15 08:30:23.169992 +00:00', '2023-05-05 08:30:23.169992 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_83', 'user_83', 'user83@example.com', 'Lawrence',  'Bahringer',    '818 Sporer Harbors, New Delanaberg, AR 58141',                 '1925-06-17', '2022-09-18 08:30:23.170376 +00:00', '2022-12-31 08:30:23.170376 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_84', 'user_84', 'user84@example.com', 'Pablo',     'VonRueden',    '2364 Altenwerth Neck, Port Granville, NC 33716',               '1985-01-19', '2022-05-12 08:30:23.170784 +00:00', '2022-10-14 08:30:23.170784 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_85', 'user_85', 'user85@example.com', 'Margery',   'Hyatt',        'Apt. 650 55429 Desirae Pines, Hueyland, DE 67984',             '1930-05-17', '2022-08-22 08:30:23.171187 +00:00', '2022-12-19 08:30:23.171187 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_86', 'user_86', 'user86@example.com', 'Jeff',      'Kshlerin',     '032 Bernard Expressway, West Joanestad, WA 11851',             '1930-07-02', '2023-03-21 08:30:23.171579 +00:00', '2023-04-03 08:30:23.171579 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_87', 'user_87', 'user87@example.com', 'Wilford',   'Kemmer',       'Suite 290 2006 Kovacek Lodge, Port Homer, MD 71250',           '1941-03-06', '2022-12-22 08:30:23.171984 +00:00', '2023-01-13 08:30:23.171984 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_88', 'user_88', 'user88@example.com', 'Nigel',     'Predovic',     '473 Delicia Lodge, Lenfort, NY 80193',                         '1985-07-18', '2022-10-04 08:30:23.172360 +00:00', '2022-10-16 08:30:23.172360 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_89', 'user_89', 'user89@example.com', 'Roland',    'Tromp',        '5000 Dach Crest, Marionport, CA 69476',                        '1929-01-06', '2023-02-10 08:30:23.172758 +00:00', '2023-02-12 08:30:23.172758 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_91', 'user_91', 'user91@example.com', 'Sumiko',    'Swaniawski',   'Suite 484 95810 Gislason Alley, West Grady, CO 14556',         '1965-12-18', '2023-04-15 08:30:23.173556 +00:00', '2023-04-30 08:30:23.173556 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_92', 'user_92', 'user92@example.com', 'Lashay',    'Howell',       'Apt. 959 21365 Fahey Ramp, East Hansbury, NJ 24836',           '1942-04-11', '2023-03-03 08:30:23.173991 +00:00', '2023-03-18 08:30:23.173991 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_93', 'user_93', 'user93@example.com', 'Caterina',  'Abbott',       '9662 Dickinson Mission, Eldonview, NV 15982',                  '1931-06-18', '2022-09-10 08:30:23.174447 +00:00', '2022-12-26 08:30:23.174447 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_94', 'user_94', 'user94@example.com', 'Brandy',    'Grady',        '28056 Patrick Land, West Sarahport, ID 71896',                 '1965-10-22', '2022-08-21 08:30:23.174850 +00:00', '2023-02-15 08:30:23.174850 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_95', 'user_95', 'user95@example.com', 'Miguel',    'Bednar',       'Apt. 018 119 Farrell Lakes, Suzannshire, OR 54856',            '1990-07-13', '2022-10-11 08:30:23.175231 +00:00', '2023-03-07 08:30:23.175231 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_96', 'user_96', 'user96@example.com', 'Eve',       'Collins',      'Suite 671 797 Carrol Shoals, North Emoryburgh, NJ 89690',      '1998-05-23', '2022-11-11 08:30:23.175622 +00:00', '2023-03-04 08:30:23.175622 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_97', 'user_97', 'user97@example.com', 'Ricky',     'Mosciski',     '4507 McLaughlin Stream, Bennyville, MO 45928',                 '1973-06-30', '2023-01-21 08:30:23.176026 +00:00', '2023-02-03 08:30:23.176026 +00:00'),
(FALSE, (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_98', 'user_98', 'user98@example.com', 'Lashaunda', 'Parisian',     '81880 Kovacek Forge, Tanishaland, WA 81150',                   '1990-09-30', '2023-03-05 08:30:23.176411 +00:00', '2023-03-08 08:30:23.176411 +00:00'),
(TRUE,  (SELECT uuid FROM user_profile WHERE privilege = 'customer'), 'password_99', 'user_99', 'user99@example.com', 'Nancie',    'Mayert',       '863 Strosin Mountains, Deandreaburgh, MN 12287',               '1945-05-22', '2023-01-23 08:30:23.176793 +00:00', '2023-04-25 08:30:23.176793 +00:00');
