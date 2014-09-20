#include <string>
#include <iostream>
#include <deque>
using namespace std;
void encode_word_helper(string &s, int i);
string reduce (const string &s);
void encode_word(string &s)
{
    encode_word_helper(s, 0);
}

void encode_word_helper(string &s, int i)
{
    if (i == s.size())
    {
        cout << reduce(s) << endl;
        return;
    }
    char c = s[i];
    encode_word_helper(s, i + 1);
    s[i] = '1';
    encode_word_helper(s, i + 1);
    s[i] = c;
}

string reduce (const string &s)
{
    string ret;
    int i = 0;
    while (i < s.size())
    {
        if (s[i] == '1')
        {
            int cnt = 0;
            for (; i < s.size(); i++)
            {
                if (s[i] == '1')
                {
                    cnt++;
                }
                else
                {
                    break;
                }
            }
            ret += to_string(cnt);
        }
        else
        {
            ret.push_back(s[i++]);
        }
    }
    return ret;
}

int main()
{

    string s = "home";
    encode_word(s);
}
/******************************************************************************************************/
#include <iostream>
#include <string>
#include <ctype.h>
using namespace std;
void encode(string str, int i);
int main()
{
    string str = "10x";
    encode(str, 0);
}

void encode(string str, int i)
{
    if (i == str.length())
    {
        cout << str << " ";
        return;
    }
    encode(str, i+1);

    if (i == 0)
    {
        str[i] = '1';
        encode(str, i+1);
    }
    else
    {
        if (!isdigit(str[i-1]))
        {
            str[i] = '1';
            encode(str, i+1);
        }
        else
        {
            str[i-1] ++;
            str = str.substr(0, i) + str.substr(i+1, str.length()-1-i);
            encode(str, i);
        }
    }
}
