SELECT REST_INFO.REST_ID AS REST_ID,REST_NAME,FOOD_TYPE,FAVORITES,ADDRESS,ROUND(AVG(REVIEW_SCORE),2) AS SCORE
FROM REST_INFO JOIN REST_REVIEW USING(REST_ID)
WHERE ADDRESS LIKE "서울%"
GROUP BY REST_ID
ORDER BY SCORE DESC, FAVORITES DESC;
