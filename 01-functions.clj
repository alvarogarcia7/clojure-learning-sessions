;; a bit about clojure functions
; main source: https://clojuredocs.org/clojure.core/defn

; see (source defn)

; defn is the same as (def name (fn [params* ] exprs*)) or
; (def name (fn ([params* ] exprs*)+))

; this is a function without parameters
(defn no-params []
  8)

(no-params)
; 8

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
;1

(identity-multiple 1 2)
; {1 2}

(identity-multiple 1 2 3)
; [1 2 3]

(identity-multiple 1 2 3 4)
; [1 2 3 4]
