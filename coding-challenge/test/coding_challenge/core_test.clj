(ns coding-challenge.core-test
  (:require [clojure.test :refer :all]
            ;add your solution namespace here!
            [coding-challenge.jan.solution-jan :as core]
            [coding-challenge.clemens.solution-clemens :as core]
            ))

(def solution-1
  [{:name "micha", :distance 20, :time 1.5, :kph 13.333333333333334}
   {:name "micha", :distance 10, :time 0.5, :kph 20.0} 
   {:name "micha", :distance 80, :time 5.5, :kph 14.545454545454545}
   {:name "micha", :distance 120, :time 10.5, :kph 11.428571428571429} 
   {:name "lukas", :distance 200, :time 20.25, :kph 9.876543209876543} 
   {:name "lukas", :distance 2, :time 0.5, :kph 4.0}
   {:name "lukas", :distance 0.5, :time 0.5, :kph 1.0}
   {:name "clemens", :distance 10, :time 0.5, :kph 20.0}
   {:name "clemens", :distance 65, :time 4.0, :kph 16.25}
   {:name "clemens", :distance 42, :time 42, :kph 1} 
   {:name "peter", :distance 25, :time 1, :kph 25}])

(def solution-add-to-data
  [{:name "micha", :distance 20, :time 1.5} 
   {:name "micha", :distance 10, :time 0.5} 
   {:name "micha", :distance 80, :time 5.5} 
   {:name "micha", :distance 120, :time 10.5} 
   {:name "lukas", :distance 200, :time 20.25} 
   {:name "lukas", :distance 2, :time 0.5}
   {:name "lukas", :distance 0.5, :time 0.5}
   {:name "clemens", :distance 10, :time 0.5} 
   {:name "clemens", :distance 65, :time 4.0} 
   {:name "clemens", :distance 42, :time 42} 
   {:name "peter", :distance 25, :time 1}
  ;this one got added 
   {:name "lustig", :distance 1, :time 1}])

(deftest test-add-average-kph-to-data
  (testing "FIXME, I fail."
    (is (= (core/add-average-kph-to-data core/data) solution-1))))
    

(deftest test-distance-sum-of-meissa-members
  (testing
   (is (= 
        549.5
        (core/distance-sum-of-meissa-members core/data)))))

(deftest test-add-to-data
  (testing 
   (is (= solution-add-to-data
          (core/add-to-data core/data {:name "lustig" :distance 1 :time 1})))))

(deftest test-my-map
  (testing 
   (is (= (map inc [1 23 4 534 34 3])
          (core/my-map inc [1 23 4 534 34 3])))))
          