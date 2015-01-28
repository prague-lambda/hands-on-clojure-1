(ns prague-lambda.hands-on.intro)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;	Basic types
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; comments :)

;; numbers
1
3.1415926

;; booleans
true
false

;; nil
nil

;; strings
"Fooobar"

;; keywords
:foo
:name.space/foo

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;	Symbols and variables
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; (undefined) symbol
foo
name.space/foo

;; quoted / escaped symbol
'foo

;; a variable
(def foo 1)

;; value of variable
foo
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;	Calling functions - prefix syntax
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; (f arg1 arg2 arg3 ...)
(+ 1 2 3)

(str "Hello," " " "world!")

;; arbitrary nesting
(+ 1 (* 2 (count "Hello, world")))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;	Vectors
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; empty sequence
nil

;; vector
[]
[1 2 3 4]

;; nested vectors
(def v1 [:foo "bar" [:baz 1]])

;; functions on vectors
(count v1)
(nth v1 1)
(get v1 2)
(get-in v1 [2 0])

;; vector has a function interface too
(v1 1)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;	Sequences
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; squence, first and rest
(seq v1)

(first v1)
(rest v1)

;; lists
(def l1 (list 1 2 3 4))

(first l1)
(rest l1)

(interleave v1 l1)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;	Maps and sets
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; maps
(def m1 {:foo 1, :bar 2, [:complex-key 1] 3})

(seq m1)

(get m1 :foo)

(:foo m1)

(keys m1)

(vals m1)

;; sets
(def s1 #{:foo :bar :baz})

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;	Functions
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; anonymous lambda
(fn [a] (+ 1 a))

;; lambda application
((fn [a] (+ 1 a)) 2)

;; function definition
(def inc-1 (fn [a] (+ 1 a)))

(inc-1 2)

;; shorter
(defn inc-1 [a]
  (+ 1 a))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;      Functions can be parameters too
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(map inc-1 [1 2 3])

(filter odd? [1 2 3 4 5 ])

(filter (partial + 1) [1 2 3 4])

(map (comp (partial + 1) (partial * 2)) [0 1 2 3 4])

(map (fn [a] (+ 1 (* 2))) [0 1 2 3 4])

;; shorter
(map #(+ 1 (* 2 %)) [0 1 2 3 4])

(into [] (map inc [1 2 3 4]))

;; syntactic sugar
(->> (map inc [0 1 2 3 4])
     (into []))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;;	Special forms
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(if true :true :false)

(let [v1  1
      v2  2]
  {v1 v2})

(cond
  ;; conditions and expressions
  (false? true) :one

  ;; ...

  :else :default-value)


;; loop - recur
(loop [var 10]
  (when (pos? var)
    (prn var)
    (recur (dec var))))


(reduce (fn [acc value]
          (if (odd? value)
            (conj acc value)
            acc))
        []
        (range 20))

(->> (range 20)
     (filter odd?)
     (reduce conj []))
