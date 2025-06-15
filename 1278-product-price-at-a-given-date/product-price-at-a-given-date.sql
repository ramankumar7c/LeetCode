WITH 
  LatestPriceBeforeDate AS (
    SELECT 
      p1.product_id,
      p1.new_price
    FROM Products p1
    WHERE p1.change_date = (
      SELECT MAX(p2.change_date)
      FROM Products p2
      WHERE p2.product_id = p1.product_id
      AND p2.change_date <= '2019-08-16'
    )
  ),
  AllProducts AS (
    SELECT DISTINCT product_id
    FROM Products
  )
SELECT
  a.product_id,
  COALESCE(l.new_price, 10) AS price
FROM AllProducts a
LEFT JOIN LatestPriceBeforeDate l ON a.product_id = l.product_id;