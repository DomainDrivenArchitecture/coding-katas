(ns coding-challenge.clemens.solution-clemens
  (:require [clojure.core.reducers :as r]))

(def data
  [{:name "micha" :distance 20 :time 1.5} {:name "micha" :distance 10 :time 0.5} {:name "micha" :distance 80 :time 5.5} {:name "micha" :distance 120 :time 10.5}
   {:name "lukas" :distance 200 :time 20.25} {:name "lukas" :distance 2 :time 0.5} {:name "lukas" :distance 0.5 :time 0.5}
   {:name "clemens" :distance 10 :time 0.5} {:name "clemens" :distance 65 :time 4.0} {:name "clemens" :distance 42 :time 42}
   {:name "peter" :distance 25 :time 1}])

(def meissa-members #{"micha" "lukas" "clemens" "ansgar" "mattis" "jan"})
; 
; Goal of this coding challenge is to become a bit more familiar with basic clojure functions such as map, filter, reduce,recur etc.
; You can use whatever you want to solve the functions but ideally you want to stick to those functions.


; calculate the average kilometres per hour and add them to data and return it
(defn add-average-kph-to-data
  [data]
  (letfn [(add-avg-kph-to-datum
            [d]
            (assoc d :kph (/ (:distance d) (:time d))))]
    (map add-avg-kph-to-datum data)))

; calculate the distance of all meissa members travelled together
; Hint: Not sure where Peter works but it is probably not meissa
(defn distance-sum-of-meissa-members
  [data]
  (let [only-members (filter #(contains? meissa-members (:name %)) data)]
    (r/fold + (map #(:distance %) only-members))))

; add all people in & args to data and return it
(defn add-to-data
  [data & args]
  (let [people (filter (fn [d]
                         (and
                          (contains? d :name)
                          (contains? d :distance)
                          (contains? d :time)))
                       args)]
    (concat data people)))

;
; Here it gets a bit more tricky
; You can google the solution but try to understand it
;

; Implement the well known map function without using it directly (ideally with functions such as fold known from functional programming)
(defn my-map
  "takes a function f and applies it on every element of list xs"
  [f xs]
  (reverse
   (r/fold
    (fn
      ([ls l] (conj ls (f l)))
      ([] '()))
    xs)))


