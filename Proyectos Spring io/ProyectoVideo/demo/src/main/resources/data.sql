INSERT INTO players (id, username, password, email, avatar, last_login, created_at, updated_at)
VALUES (10000, 'APP', null, null, null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO players (id, username, password, email, avatar, last_login, created_at, updated_at)
VALUES (100, 'Martin', 'Password03#', 'email@email.com', null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO games (id, code, name, description, rules)
VALUES (10000, 'RPS', 'RockPaperScissors', 'Descripcion muy larga', 'Reglas que nadie va a leer');

INSERT INTO matches (id, game_id, player1_id, player2_id, created_at, updated_at, status)
VALUES (10000, 10000, 100,10000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'STARTED');
INSERT INTO matches (id, game_id, player1_id, player2_id, created_at, updated_at, status)
VALUES (10001, 10000, 100,10000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'FINISHED');
INSERT INTO matches (id, game_id, player1_id, player2_id, created_at, updated_at, status)
VALUES (10002, 10000, 100, 10000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'CANCELED');

INSERT INTO matches_rps(id, number_of_plays, remainder_plays, player1score, player2score)
VALUES (10000, 3, 1, 1, 1);
INSERT INTO matches_rps(id, number_of_plays, remainder_plays, player1score, player2score, winner_id)
VALUES (10001, 3, 0, 3, 0, 100);
INSERT INTO matches_rps(id, number_of_plays, remainder_plays, player1score, player2score)
VALUES (10002, 3, 1, 1, 1);

INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1000, 10000, 'ROCK', 'PAPER', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1001, 10000, 'PAPER', 'ROCK', 10000);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1010, 10001, 'ROCK', 'PAPER', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1011, 10001, 'ROCK', 'PAPER', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1012, 10001, 'ROCK', 'PAPER', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1020, 10002, 'ROCK', 'PAPER', 100);
INSERT INTO plays_rps(id, match_rps_id, shape_hand_player1, shape_hand_player2, winner_id)
VALUES (1021, 10002, 'PAPER', 'ROCK', 10000);



