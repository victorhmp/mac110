n = 6
a = 2
b = 3

alpha = "abcdefghijklmnopqrstuvwxyz"

i = 0;
def perm (permutado, a_permutar, decr, crec):
    if a_permutar == "":
        print permutado, max(decr), max(crec)
        return 1
    else: 
        s = 0
        for i in range(0, len(a_permutar)):
            l = a_permutar[i]
            ii = len(permutado)

            decr[ii] = 0
            crec[ii] = 0

            max_crec = 0
            max_decr = 0
            for j in range(0, len(permutado)):
                if l > permutado[j] and decr[ii] < decr[j]:
                    decr[ii] = decr[j]
                if l < permutado[j] and crec[ii] < crec[j]:
                    crec[ii] = crec[j]

                if max_decr < decr[j]:
                    max_decr =  decr[j]
                if max_crec < crec[j]:
                    max_crec =  crec[j]

            decr[ii] =  decr[ii] + 1
            crec[ii] =  crec[ii] + 1
            if max_decr < decr[ii]:
                max_decr =  decr[ii]
            if max_crec < crec[ii]:
                max_crec =  crec[ii]

            if max_decr <= a and max_crec <= b:
                s = s + perm (permutado + l, a_permutar[:i] + a_permutar[i+1:], decr, crec)
        return s


decr = [0] * n
crec = [0] * n
print perm("", alpha[:n], decr, crec)