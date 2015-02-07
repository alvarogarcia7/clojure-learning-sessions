; ## a bit about clojure functions
; main source: https://clojuredocs.org/clojure.core/defn

; see (source defn)

; defn is the same as (def name (fn [params* ] exprs*)) or
; (def name (fn ([params* ] exprs*)+))

; this is a function without parameters
(defn no-params []
  8)

(no-params)
; 8

; the last command will be executed and returned
(defn last-command []
  8
  1
  (inc 1))

(last-command)
; 2

; this is a function with one parameter
; as "identity" is already a function, we name it otherwise
(defn identity-
  "as it returns the parameter, we call it identity"
  [x]
  x)

(identity- 1)
; 1

(=
 (identity 1)
 (identity- 1))
; true

(meta #'identity-) ; works both in IDE and repl

(source +) ; only works in repl

(defn identity-multiple
  "functions can have multiple sets of parameters (overload)"
  ([x] x)
  ([x y & z] (apply conj [x y] z)) ; x and y are mandatory, the rest are optional
  ([x y] {x y}) ; the order does not matter
  )

(identity-multiple 1)
; 1

(identity-multiple 1 2)
; {1 2}

(identity-multiple 1 2 3)
; [1 2 3]

(identity-multiple 1 2 3 4)
; [1 2 3 4]


(defn named-parameters
  "you can name parameters, like in python"
  [{name- :name}]
  name-)

(named-parameters "a")
; nil

(named-parameters {:name ["a"]})
; ["a"]

(named-parameters {:name "b"})
; "b"


; copy for advanced parameters, including optional
; https://clojuredocs.org/clojure.core/defn
(defn somefn
  [req1 req2 ;required params
   & {:keys [a b c d e] ;optional params
      :or {a 1 ;optional params with preset default values other than the nil default
                  ; b takes nil if not specified on call
            c 3 ; c is 3 when not specified on call
            d 0 ; d is 0 --//--
                  ; e takes nil if not specified on call
           }
      :as mapOfParamsSpecifiedOnCall ;takes nil if no extra params(other than the required ones) are specified on call
      }]
  (println req1 req2 mapOfParamsSpecifiedOnCall a b c d e)
  )

; private functions
(defn- private []
  "s3cr3t stuff")

; recursive functions
(defn revers [x]
  (if (> x 0)
    (conj (revers (dec x)) x)
    '()))

(revers 10)
; (10 9 8 7 6 5 4 3 2 1)

; lambda - anonymous functions
(map (fn [x] x) '(1 2 3))
; (1 2 3)

; this is not going to work
; #(%) : see http://stackoverflow.com/questions/13204993/anonymous-function-shorthand
; it's converted to (fn [x] (x))

(map #(-> %) '(1 2 3)) ; % or %1 is the first parameter
; (1 2 3)

(map #(-> [%1]) '(1 2 3))
; ([1] [2] [3])

