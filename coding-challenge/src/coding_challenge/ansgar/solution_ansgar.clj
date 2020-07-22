(ns coding-challenge.ansgar.solution-ansgar
  (:require [clojure.core.reducers :as r]))

(def data
  [{:name "micha" :distance 20 :time 1.5} {:name "micha" :distance 10 :time 0.5} {:name "micha" :distance 80 :time 5.5} {:name "micha" :distance 120 :time 10.5}
   {:name "lukas" :distance 200 :time 20.25} {:name "lukas" :distance 2 :time 0.5} {:name "lukas" :distance 0.5 :time 0.5}
   {:name "clemens" :distance 10 :time 0.5} {:name "clemens" :distance 65 :time 4.0} {:name "clemens" :distance 42 :time 42}
   {:name "peter" :distance 25 :time 1}])

; 
; Goal of this coding challenge is to become a bit more familiar with basic clojure functions such as map, filter, reduce,recur etc.
; You can use whatever you want to solve the functions but ideally you want to stick to those functions.


; calculate the average kilometres per hour and add them to data and return it
(defn add-average-kph-to-data
  [data]
  (map #(conj % {:kph (/ (:distance %) (:time %))}) data))


; calculate the distance of all meissa members travelled together
(defn isInMeissa? [x]
  (contains? #{"micha" "lukas" "clemens" "jan" "ansgar"} (:name x)))

(defn distance-sum-of-meissa-members
  [data]
  (r/fold + (map :distance (filterv isInMeissa? data))))


; add all people in & args to data and return it
(defn add-to-data
  [data & args]
  (into [] (concat data args)))


;
; Here it gets a bit more tricky
; You can google the solution but try to understand it
;

; Implement the well known map function without using it directly (ideally with functions such as fold known from functional programming)
(defn my-map
  "takes a function f and applies it on every element of list xs"
  [f x]
  (if (not (empty? x)) (conj (my-map f (rest x)) (f (first x)))))
